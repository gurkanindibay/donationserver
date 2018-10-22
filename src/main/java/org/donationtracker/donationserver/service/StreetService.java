package org.donationtracker.donationserver.service;

import org.donationtracker.donationserver.repository.StreetRepository;
import org.springframework.stereotype.Service;

@Service
public class StreetService {

    private final StreetRepository streetRepository;

    public StreetService(StreetRepository streetRepository){
        this.streetRepository = streetRepository;
    }
}
