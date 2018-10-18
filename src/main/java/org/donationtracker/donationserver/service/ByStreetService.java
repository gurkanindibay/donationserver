package org.donationtracker.donationserver.service;

import org.donationtracker.donationserver.repository.AddressRepository;
import org.donationtracker.donationserver.repository.ByStreetRepository;
import org.springframework.stereotype.Service;

@Service
public class ByStreetService {

    private ByStreetRepository byStreetRepository;

    public ByStreetService(ByStreetRepository byStreetRepository){
        this.byStreetRepository = byStreetRepository;
    }
}
