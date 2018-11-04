package org.donationtracker.donationserver.configuration;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@PropertySource("classpath:version.properties")
@PropertySource("classpath:git.properties")

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FeaturesEndpointTests {
    @Value("${buildVersion}")
    private String buildVersion;

    @Value("${git.build.time}")
    private String buildDate;

    @Value("${git.commit.id.abbrev}")
    private String lastCommit;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testVersionCheck() throws JSONException {
        String response = restTemplate.withBasicAuth("user", "password").getForObject("/actuator/d-features", String.class);
        JSONAssert.assertEquals(
                "{buildVersion: \"" + buildVersion + "\", lastCommit:" + lastCommit + ",  buildDate: \"" + buildDate + "\" }", response,
                false);
    }

}
