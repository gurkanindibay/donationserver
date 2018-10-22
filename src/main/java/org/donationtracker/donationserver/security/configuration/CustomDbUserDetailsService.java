package org.donationtracker.donationserver.security.configuration;

import org.donationtracker.donationserver.security.model.User;
import org.donationtracker.donationserver.security.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("customDbUserDetailsService")
public class CustomDbUserDetailsService implements UserDetailsService {

    private final UserService userService;

    public CustomDbUserDetailsService(UserService userService){
        this.userService = userService;
    }


    @Override
    public UserDetails loadUserByUsername(String username) {
        Optional<User> user = userService.getUser(username);
        if (!user.isPresent()) throw new UsernameNotFoundException(username);
        return user.get();
    }

}


