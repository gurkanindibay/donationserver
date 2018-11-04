package org.donationtracker.donationserver.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PageController.class)
public class PageControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    @WithMockUser(username = "user", password = "password123")
    public void getInternationalPage_Test() throws Exception {
        mvc.perform(get("/international").contentType(MediaType.TEXT_PLAIN)).andExpect(status().isOk());
    }
}
