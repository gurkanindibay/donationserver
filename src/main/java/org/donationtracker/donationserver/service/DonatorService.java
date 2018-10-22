package org.donationtracker.donationserver.service;

import org.donationtracker.donationserver.repository.DonatorRepository;
import org.springframework.stereotype.Service;

@Service
public class DonatorService {

    private final DonatorRepository donatorRepository;

    public DonatorService(DonatorRepository donatorRepository){
        this.donatorRepository = donatorRepository;
    }
}
