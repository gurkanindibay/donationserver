package org.donationtracker.donationserver;

import org.donationtracker.donationserver.repository.CityRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DonationserverApplicationTests {

    @Autowired
    CityRepository cityRepository;
    @Test
    public void contextLoads() {
        cityRepository.findAll();
    }

}
