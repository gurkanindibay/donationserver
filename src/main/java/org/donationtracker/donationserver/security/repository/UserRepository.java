package org.donationtracker.donationserver.security.repository;

import org.donationtracker.donationserver.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findFirstByUsername(String userName);

    @Query("update User set password = :password where token=:token")
    void updatePasswordWithToken(@Param("token") String token, @Param("password") String password);

    Optional<User> findFirstByUsernameAndIsDeletedIsFalse(String userName);

    @Modifying
    @Query("update User set isAccountNonLocked = false where id= :userId")
    void lockUser(@Param("userId") Long userId);

    @Modifying
    @Query("update User set failedLoginCount = failedLoginCount + 1 where id= :userId")
    void increaseFailedLoginCount(@Param("userId") Long userId);


}

