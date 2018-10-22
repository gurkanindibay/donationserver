package org.donationtracker.donationserver.service;

import org.donationtracker.donationserver.repository.DoneeRepository;
import org.springframework.stereotype.Service;

@Service
public class DoneeService {

    private final DoneeRepository doneeRepository;

    public DoneeService(DoneeRepository doneeRepository){
        this.doneeRepository = doneeRepository;
    }
}
