package org.donationtracker.donationserver.repository;

import org.donationtracker.donationserver.model.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistrictRepository extends JpaRepository<District,Long> {
}
