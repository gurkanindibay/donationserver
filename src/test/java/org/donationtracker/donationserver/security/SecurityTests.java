package org.donationtracker.donationserver.security;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SecurityTests {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testAuthentication_successful() {
        ResponseEntity<String> response = restTemplate.withBasicAuth("user", "password").getForEntity("/test", String.class);
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
    @Test
    public void testAuthentication_unsuccessful() {
        ResponseEntity<String> response = restTemplate.withBasicAuth("user1", "password1").getForEntity("/test", String.class);
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.UNAUTHORIZED);
    }
    @Test
    public void testAnonymousUser_login(){
        ResponseEntity<String> response = restTemplate.getForEntity("/public", String.class);
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

}
