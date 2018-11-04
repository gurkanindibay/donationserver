package org.donationtracker.donationserver.service;

import org.donationtracker.donationserver.model.Donator;
import org.donationtracker.donationserver.repository.DonatorRepository;
import org.springframework.stereotype.Service;

@Service
public class DonatorService extends BaseServiceImpl<Donator, Long> {

    private final DonatorRepository donatorRepository;

    public DonatorService(DonatorRepository donatorRepository) {
        super(donatorRepository);
        this.donatorRepository = donatorRepository;
    }
}
