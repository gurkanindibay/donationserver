package org.donationtracker.donationserver;

import org.donationtracker.donationserver.model.City;
import org.donationtracker.donationserver.repository.CityRepository;

import java.util.List;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class DonationserverApplicationTests {

    //@Autowired
    private CityRepository cityRepository;
    //@Test
    public void contextLoads() {
        City city = new City();
        city.setName("Istanbul");
        cityRepository.save(city);

        List<City> cityList =  cityRepository.findAll();
        cityList.forEach(c-> System.out.println(c.getName()));
    }

}
