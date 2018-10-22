package org.donationtracker.donationserver.controller;

import org.donationtracker.donationserver.model.City;
import org.donationtracker.donationserver.repository.CityRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TestController {

    private final CityRepository cityRepository;

    public TestController (CityRepository cityRepository){
        this.cityRepository = cityRepository;
    }

    @GetMapping("/test")
    @ResponseBody
    public City test() {
        City city = new City();
        city.setName("Istanbul");
        cityRepository.save(city);
        return city;
    }

    @GetMapping("/test2")
    @ResponseBody
    public List<City> test2() {
        return cityRepository.findAll();
    }
}
