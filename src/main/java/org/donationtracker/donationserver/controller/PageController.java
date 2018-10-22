package org.donationtracker.donationserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class    PageController {

    @GetMapping("/international")
    public String getInternationalPage() {
        return "international";
    }
}
