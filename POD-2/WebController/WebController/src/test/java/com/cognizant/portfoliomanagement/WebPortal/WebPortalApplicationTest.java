package com.cognizant.portfoliomanagement.WebPortal;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cognizant.portfoliomanagement.WebPortal.Controller.WebPortalController;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
class WebPortalApplicationTest {

	@Autowired
    private WebPortalController controller;

    @Autowired
    private MockMvc mvc;
    
    @Test
    void contextLoads() {
        assertNotNull(controller);
    }
    
    @Test
    public void testGetLogout() throws Exception {
      
        mvc.perform(MockMvcRequestBuilders
         .get("/logout"))
         .andExpect(status().isOk());

    }
    
    @Test
    public void testGetLogin() throws Exception {
      
        mvc.perform(MockMvcRequestBuilders
         .get("/"))
         .andExpect(status().isOk());

    }
    
    /*@Test
    public void testPostLogin() throws Exception {
      
        mvc.perform(MockMvcRequestBuilders
         .get("/login"))
         .andExpect(status().isMethodNotAllowed());

    }*/
    
    @Test
    public void testGetHomePage() throws Exception {
      
        mvc.perform(MockMvcRequestBuilders
         .get("/Home"))
         .andExpect(status().isOk());

    }
}
