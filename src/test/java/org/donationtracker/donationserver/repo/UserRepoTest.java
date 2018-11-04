package org.donationtracker.donationserver.repo;

import org.donationtracker.donationserver.security.model.User;
import org.donationtracker.donationserver.security.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepoTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testLockUser_LockAndVerify() {

        userRepository.lockUser(1L);

        Optional<User> user = userRepository.findById(1L);
        if (user.isPresent()) {
            assertThat(user.get().isAccountNonLocked()).isFalse();
        }
    }

    @Test
    public void testFindByUserName() {
        Optional<User> user = userRepository.findFirstByUsername("user");
        user.ifPresent(u -> {
            assertThat("userfname").isEqualTo(u.getFname());
        });
        user.orElseThrow(() -> new AssertionError("User could not be found"));
    }

    @Test
    public void testUpdatePasswordWithToken() {
        String token = "123";
        String password = "12345";
        userRepository.updatePasswordWithToken(token, password);
        Optional<User> user = userRepository.findFirstByToken(token);

        user.ifPresent(u -> assertThat(password).isEqualTo(u.getPassword()));
        user.orElseThrow(() -> new AssertionError("User could not be found"));
    }

    public void testIncreaseFailedLoginCount() {
        Optional<User> user = userRepository.findFirstByUsername("user");
        AtomicLong failedLoginCount = new AtomicLong(0L);

        final AtomicReference<Optional<User>>[] user2 = new AtomicReference[1];

        user.ifPresent(u -> {
            failedLoginCount.set(u.getFailedLoginCount());
            userRepository.increaseFailedLoginCount(user.get().getId());
            Optional<User> userFetched = userRepository.findById(user.get().getId());
            userFetched.ifPresent(uF -> assertThat(uF.getFailedLoginCount()).isEqualTo(failedLoginCount.get() + 1));
            userFetched.orElseThrow(() -> new AssertionError("User with user name \"user\" does not exist"));
        });
        user.orElseThrow(() -> new AssertionError("User with user name \"user\" does not exist"));
    }

    public void testFindFirstByUserName_ExistingUser() {
        Optional<User> user = userRepository.findFirstByUsername("user");
        assertThat(user.isPresent()).isTrue();
    }

    public void testFindFirstByUserName_NonExistingUser() {
        Optional<User> user = userRepository.findFirstByUsername("user_nonexistent");
        assertThat(user.isPresent()).isFalse();
    }

}
