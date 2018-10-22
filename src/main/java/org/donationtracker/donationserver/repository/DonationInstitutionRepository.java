package org.donationtracker.donationserver.repository;

import org.donationtracker.donationserver.model.DonationInstitution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonationInstitutionRepository extends JpaRepository<DonationInstitution,Long> {
}
