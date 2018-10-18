package org.donationtracker.donationserver.service;

import org.donationtracker.donationserver.repository.AddressRepository;
import org.donationtracker.donationserver.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
}
