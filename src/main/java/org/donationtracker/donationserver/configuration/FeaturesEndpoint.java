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

    @Value("${buildVersion}")
    private String buildVersion;
    @Value("${git.build.time}")
    private String buildDate;
    @Value("${git.commit.id.abbrev}")
    private String lastCommit;

    private final Map<String, String> features = new ConcurrentHashMap<>();

    @ReadOperation
    public Map<String, String> features() {
        return features;
    }

    @ReadOperation
    public String feature(@Selector String name) {
        return features.get(name);
    }

    @WriteOperation
    public void configureFeature(@Selector String name, String feature) {
        features.put(name, feature);
    }

    @DeleteOperation
    public void deleteFeature(@Selector String name) {
        features.remove(name);
    }

    @PostConstruct
    public void fillFeatures(){
        features.put("buildVersion",buildVersion );
        features.put("buildDate",buildDate );
        features.put("lastCommit",lastCommit );
    }



}