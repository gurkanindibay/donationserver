package org.donationtracker.donationserver.service;

import org.donationtracker.donationserver.model.ByStreet;
import org.donationtracker.donationserver.repository.ByStreetRepository;
import org.springframework.stereotype.Service;

@Service
public class ByStreetService extends BaseServiceImpl<ByStreet, Long> {

    private final ByStreetRepository byStreetRepository;

    public ByStreetService(ByStreetRepository byStreetRepository) {
        super(byStreetRepository);
        this.byStreetRepository = byStreetRepository;
    }
}
