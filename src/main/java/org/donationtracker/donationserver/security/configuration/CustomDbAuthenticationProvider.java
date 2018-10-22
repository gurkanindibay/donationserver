package org.donationtracker.donationserver.security.configuration;

import org.donationtracker.donationserver.security.model.User;
import org.donationtracker.donationserver.security.enums.UserOperationType;
import org.donationtracker.donationserver.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("authenticationProvider")
@ConditionalOnExpression("'${app.authentication.provider:DATABASE}'=='DATABASE'")
public class CustomDbAuthenticationProvider extends DaoAuthenticationProvider {


    private final UserService userService;

    private final UserOperationLoggerUtil loggerUtil;

    public CustomDbAuthenticationProvider(UserService userService,UserOperationLoggerUtil loggerUtil,CustomDbUserDetailsService userDetailsService ){
        super();
        this.userService = userService;
        this.loggerUtil = loggerUtil;
        this.setUserDetailsService(userDetailsService);
    }

    @Bean(name = "passwordEncoder")
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(5);
    }



    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        try {
            authentication = super.authenticate(authentication);

            loggerUtil.saveUserOperation(UserOperationType.LOGIN_SUCCESS, null, (User) authentication.getPrincipal());

            return authentication;
        } catch (BadCredentialsException e) {
            updateUserFailedLoginCount(authentication.getName());
            throw e;
        }
    }

    private void updateUserFailedLoginCount(String name) {
        Optional<User> user = userService.getUser(name);
        if (user.isPresent()) {
            if (user.get().getFailedLoginCount() == 3) {
                userService.lockUserWithId(user.get().getId());
            } else {
                userService.increaseFailedLoginCountWithId(user.get().getId());
            }
        }

        loggerUtil.saveUserOperation(UserOperationType.LOGIN_FAILED,
                "%USEROPERATIONS.DESC.BAD_CREDENTIALS_EXCEPTION%\n%USEROPERATIONS.DESC.USERNAME%" + name,
                user.orElseGet(() -> userService.getAnonymousUser()));
    }



    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        super.setPasswordEncoder(passwordEncoder);
    }

}
