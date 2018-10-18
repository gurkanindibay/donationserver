package org.donationtracker.donationserver.configuration;

import org.donationtracker.donationserver.model.User;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuditorAwareImpl implements AuditorAware<User> {

    @Override
    public Optional<User> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null) {
            User currentUser = (User) authentication.getPrincipal();
            if (currentUser != null) {
                return Optional.of(currentUser);
            } else {
                throw new UsernameNotFoundException("User Not Found");
            }
        } else {
            throw new AuthenticationCredentialsNotFoundException("There is no authentication!");
        }
    }

}