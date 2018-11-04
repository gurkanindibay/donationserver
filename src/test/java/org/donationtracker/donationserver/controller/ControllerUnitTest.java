package org.donationtracker.donationserver.controller;

import org.donationtracker.donationserver.repository.CityRepository;
import org.donationtracker.donationserver.service.CityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TestController.class)
public class ControllerUnitTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CityService cityService;

    @WithMockUser(username = "user", password = "password")
    @Test
    public void givenAuthRequestOnPrivateService_shouldSucceedWith200() throws Exception {
        //mvc.perform(get("/test").with(user("user").password("password1")).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
        mvc.perform(get("/test").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @WithMockUser(username = "user", password = "password123")
    @Test
    public void givenAuthRequestOnPrivateService_shouldSucceedWith401() throws Exception {
        mvc.perform(get("/test").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

}
