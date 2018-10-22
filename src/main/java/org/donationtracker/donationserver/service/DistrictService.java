package org.donationtracker.donationserver.service;

import org.donationtracker.donationserver.repository.DistrictRepository;
import org.springframework.stereotype.Service;

@Service
public class DistrictService {

    private final DistrictRepository districtRepository;

    public DistrictService(DistrictRepository districtRepository){
        this.districtRepository = districtRepository;
    }
}
