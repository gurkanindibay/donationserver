package org.donationtracker.donationserver.service;

import org.donationtracker.donationserver.model.Street;
import org.donationtracker.donationserver.repository.StreetRepository;
import org.springframework.stereotype.Service;

@Service
public class StreetService extends BaseServiceImpl<Street, Long> {

    private final StreetRepository streetRepository;

    public StreetService(StreetRepository streetRepository) {
        super(streetRepository);
        this.streetRepository = streetRepository;
    }
}
