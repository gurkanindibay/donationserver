package org.donationtracker.donationserver.service;

import org.donationtracker.donationserver.model.Address;
import org.donationtracker.donationserver.repository.AddressRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressService extends BaseServiceImpl<Address, Long> {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        super(addressRepository);
        this.addressRepository = addressRepository;
    }
}
