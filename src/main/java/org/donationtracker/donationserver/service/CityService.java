package org.donationtracker.donationserver.service;

import org.donationtracker.donationserver.model.City;
import org.donationtracker.donationserver.repository.CityRepository;
import org.springframework.stereotype.Service;

@Service
public class CityService extends BaseServiceImpl<City, Long> {

    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        super(cityRepository);
        this.cityRepository = cityRepository;
    }
}
