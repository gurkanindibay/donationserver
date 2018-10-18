package org.donationtracker.donationserver.repository;

import org.donationtracker.donationserver.model.Address;
import org.donationtracker.donationserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}