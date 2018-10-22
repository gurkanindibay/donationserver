package org.donationtracker.donationserver.repository;

import org.donationtracker.donationserver.model.Donee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoneeRepository extends JpaRepository<Donee,Long> {
}
