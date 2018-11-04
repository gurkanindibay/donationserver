package org.donationtracker.donationserver.service;

import org.donationtracker.donationserver.model.District;
import org.donationtracker.donationserver.repository.DistrictRepository;
import org.springframework.stereotype.Service;

@Service
public class DistrictService extends BaseServiceImpl<District, Long> {

    private final DistrictRepository districtRepository;

    public DistrictService(DistrictRepository districtRepository) {
        super(districtRepository);
        this.districtRepository = districtRepository;
    }
}
