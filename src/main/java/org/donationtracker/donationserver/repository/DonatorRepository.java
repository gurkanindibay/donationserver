package org.donationtracker.donationserver.repository;

import org.donationtracker.donationserver.model.Donator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonatorRepository extends JpaRepository<Donator, Long> {
}
