package org.donationtracker.donationserver.security.service;

import org.donationtracker.donationserver.security.model.User;
import org.donationtracker.donationserver.security.repository.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UserService {

    public static final String ANONYMOUS_USER = "anonymousUser";

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void lockUserWithId(Long userId) {
        userRepository.lockUser(userId);
    }

    @Transactional
    public void increaseFailedLoginCountWithId(Long userId) {
        userRepository.increaseFailedLoginCount(userId);
    }

    @Transactional
    public void updatePassword(String token, String password) {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);

        userRepository.updatePasswordWithToken(token, hashedPassword);

    }

    public Optional<User> getUser(String userName) {
        return userRepository.findFirstByUsername(userName);
    }

    public User getAnonymousUser() {
        Optional<User> user = userRepository.findFirstByUsername(ANONYMOUS_USER);
        if (user.isPresent())
            return user.get();
        else
            throw new UsernameNotFoundException("Anonymous user is not defined in the system. Please define the user info");
    }

}
