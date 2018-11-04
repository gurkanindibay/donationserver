package org.donationtracker.donationserver.service;

import org.donationtracker.donationserver.model.DonationInstitution;
import org.donationtracker.donationserver.repository.DonationInstitutionRepository;
import org.springframework.stereotype.Service;

@Service
public class DonationInstitutionService extends BaseServiceImpl<DonationInstitution, Long> {

    private final DonationInstitutionRepository donationInstitutionRepository;

    public DonationInstitutionService(DonationInstitutionRepository donationInstitutionRepository) {
        super(donationInstitutionRepository);
        this.donationInstitutionRepository = donationInstitutionRepository;
    }
}
