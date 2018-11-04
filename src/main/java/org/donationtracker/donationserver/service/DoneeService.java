package org.donationtracker.donationserver.service;

import org.donationtracker.donationserver.model.Donee;
import org.donationtracker.donationserver.repository.DoneeRepository;
import org.springframework.stereotype.Service;

@Service
public class DoneeService extends BaseServiceImpl<Donee, Long> {

    private final DoneeRepository doneeRepository;

    public DoneeService(DoneeRepository doneeRepository) {
        super(doneeRepository);
        this.doneeRepository = doneeRepository;
    }
}
