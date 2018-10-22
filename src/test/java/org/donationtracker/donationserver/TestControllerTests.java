package org.donationtracker.donationserver;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.assertEquals;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestControllerTests {


    @Autowired
    private WebApplicationContext context;

    @Autowired
    private TestRestTemplate template;

    private MockMvc mvc;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private FilterChainProxy springSecurityFilterChain;



    //@Before
    public void setup() {
        mvc = webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @Before
    public void setupWithActualSecurity() {
        mvc = webAppContextSetup(context)
                .apply(springSecurity(springSecurityFilterChain))
                .build();
    }

    //@WithMockUser(username = "user", password = "password")
    @Test
    public void givenAuthRequestOnPrivateService_shouldSucceedWith200() throws Exception {
        //mvc.perform(get("/test").with(user("user").password("password1")).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
        mvc.perform(get("/test").with(httpBasic("user","password1")).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @WithMockUser(username = "user", password = "password123")
    @Test
    public void givenAuthRequestOnPrivateService_shouldSucceedWith401() throws Exception {
        mvc.perform(get("/test").contentType(MediaType.APPLICATION_JSON)).andExpect(status().is(200));
    }

    @Test
    public void givenAuthRequestOnPrivateService_shouldSucceedWith200_rest()  {
        ResponseEntity<String> result = template.withBasicAuth("user", "password")
                .getForEntity("/test", String.class);
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }
}
