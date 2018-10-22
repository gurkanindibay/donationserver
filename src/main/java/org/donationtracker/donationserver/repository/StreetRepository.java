package org.donationtracker.donationserver.repository;

import org.donationtracker.donationserver.model.Street;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StreetRepository extends JpaRepository<Street,Long> {
}
