package org.donationtracker.donationserver.security.configuration;

import org.donationtracker.donationserver.security.model.User;
import org.donationtracker.donationserver.security.service.UserService;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.Optional;

@Component("auditorAware")
public class AuditorAwareImpl implements AuditorAware<User> {

    private final UserService userService;

    private final EntityManager entityManager;

    public AuditorAwareImpl(UserService userService, EntityManager entityManager) {

        this.userService = userService;
        this.entityManager = entityManager;
    }

    @Override
    public Optional<User> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Optional<User> currentUser = Optional.empty();
        if (authentication != null) {
            if (authentication.getPrincipal() instanceof String) {
                currentUser = userService.getUser((String) authentication.getPrincipal());
                if (currentUser.isPresent()) {
                    return currentUser;
                } else {
                    throw new UsernameNotFoundException("User Not Found");
                }

            } else if (authentication.getPrincipal() instanceof User) {
                User user = (User) authentication.getPrincipal();
                if (user != null) {
                    currentUser = Optional.of(user);
                } else {
                    throw new UsernameNotFoundException("User Not Found");
                }
            }
        } else {
            throw new AuthenticationCredentialsNotFoundException("There is no authentication!");
        }
        return currentUser;
    }

}