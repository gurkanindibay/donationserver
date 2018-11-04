package org.donationtracker.donationserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class DonationserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(DonationserverApplication.class, args);
    }
}
