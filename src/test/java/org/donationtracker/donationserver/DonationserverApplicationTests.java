package org.donationtracker.donationserver;

import org.donationtracker.donationserver.model.City;
import org.donationtracker.donationserver.repository.CityRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DonationserverApplicationTests {

    @Autowired
    CityRepository cityRepository;
    @Test
    public void contextLoads() {
        City city = new City();
        city.setName("Istanbul");
        cityRepository.save(city);

        List<City> cityList =  cityRepository.findAll();
        cityList.stream().forEach(c-> System.out.println(c.getName()));
    }

}
