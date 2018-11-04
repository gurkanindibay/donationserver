package org.donationtracker.donationserver.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.endpoint.annotation.*;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Endpoint(id = "d-features")
@PropertySource("classpath:version.properties")
@PropertySource("classpath:git.properties")
public class FeaturesEndpoint {

    private final Map<String, String> features = new ConcurrentHashMap<>();

    @Value("${buildVersion}")
    private String buildVersion;

    @Value("${git.build.time}")
    private String buildDate;

    @Value("${git.commit.id.abbrev}")
    private String lastCommit;

    @ReadOperation
    public Map<String, String> features() {
        return features;
    }


    @PostConstruct
    public void fillFeatures() {
        features.put("buildVersion", buildVersion);
        features.put("buildDate", buildDate);
        features.put("lastCommit", lastCommit);
    }
}