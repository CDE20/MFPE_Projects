package com.cognizant.portfolio_management.DailyMutualFundNAV;

 

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

 

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

 

import com.cognizant.portfolio_management.DailyMutualFundNAV.controller.MutualFundController;

 

@AutoConfigureMockMvc
@SpringBootTest
class DailyMutualFundNAVApplicationTests {

 

    @Autowired
    private MutualFundController mutualFundController;

 

    @Autowired
    private MockMvc mvc;
    
    @Test
    void contextLoads() {
        assertNotNull(mutualFundController);
    }
    @Test
    public void testGetDailyAllMutualFundNav() throws Exception {
        ResultActions actions = mvc.perform(get("/dailyAllMutualFundNav"));
        actions.andExpect(status().isOk());
        
        //actions.andExpect(jsonPath("$.mutualFundValue").exists());
        //actions.andExpect(jsonPath("$.mutualFundValue").value("9800.0"));
    }
    
    @Test
    public void testGetAllDailySharePrice() throws Exception {
        ResultActions actions = mvc.perform(get("/dailyMutualFundNav/name/Axis Bluechip fund"));
        actions.andExpect(status().isOk());
        actions.andExpect(jsonPath("$.mutualFundId").exists());
        actions.andExpect(jsonPath("$.mutualFundId").value("AXIS"));
        
        actions.andExpect(jsonPath("$.mutualFundName").exists());
        actions.andExpect(jsonPath("$.mutualFundName").value("Axis Bluechip fund"));
        
        actions.andExpect(jsonPath("$.mutualFundValue").exists());
        actions.andExpect(jsonPath("$.mutualFundValue").value("9800.0"));
    }
    
    @Test
    public void testGetDailyMutualFundNavById() throws Exception {
        ResultActions actions = mvc.perform(get("/dailyMutualFundNav/AXIS"));
        actions.andExpect(status().isOk());
        
        //actions.andExpect(jsonPath("$.mutualFundValue").exists());
        //actions.andExpect(jsonPath("$.mutualFundValue").value("9800.0"));
    }

 

}