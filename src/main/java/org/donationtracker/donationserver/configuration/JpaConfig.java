package org.donationtracker.donationserver.configuration;

import org.donationtracker.donationserver.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing()
public class JpaConfig {
    @Bean
    public AuditorAware<User> auditorAware() {
        return new AuditorAwareImpl();
    }
}