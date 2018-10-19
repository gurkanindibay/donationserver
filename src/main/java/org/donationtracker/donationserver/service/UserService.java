package org.donationtracker.donationserver.service;

import org.donationtracker.donationserver.model.User;
import org.donationtracker.donationserver.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public Optional<User> getUser(String userName){
        return userRepository.findFirstByUsername(userName);
    }
}
