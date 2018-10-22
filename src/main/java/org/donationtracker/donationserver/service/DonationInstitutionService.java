package org.donationtracker.donationserver.service;

import org.donationtracker.donationserver.repository.DonationInstitutionRepository;
import org.springframework.stereotype.Service;

@Service
public class DonationInstitutionService {

    private final DonationInstitutionRepository donationInstitutionRepository;

    public DonationInstitutionService(DonationInstitutionRepository donationInstitutionRepository){
        this.donationInstitutionRepository = donationInstitutionRepository;
    }
}
