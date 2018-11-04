package org.donationtracker.donationserver.controller;

import org.donationtracker.donationserver.model.City;
import org.donationtracker.donationserver.service.CityService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TestController {

    private final CityService cityService;

    public TestController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/test")
    @ResponseBody
    public City test() {
        City city = new City();
        city.setName("Istanbul");
        cityService.save(city);
        return city;
    }


    @GetMapping("/public")
    @ResponseBody
    public List<City> publicCall() {
        return cityService.findAll();
    }
}
