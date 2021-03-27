package com.cognizant.portfolio_management.DailySharePrice;

 

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

 

import com.cognizant.portfolio_management.DailySharePrice.controller.ShareDetailsController;

 

@AutoConfigureMockMvc
@SpringBootTest
class DailySharePriceApplicationTests {

 

    @Autowired
    private ShareDetailsController shareDetailsController;

 

    @Autowired
    private MockMvc mvc;
    
    @Test
    void contextLoads() {
        assertNotNull(shareDetailsController);
    }
    
    @Test
    public void testGetDailySharePrice() throws Exception {
        ResultActions actions = mvc.perform(get("/dailySharePrice/name/Amazon"));
        actions.andExpect(status().isOk());
        actions.andExpect(jsonPath("$.shareId").exists());
        actions.andExpect(jsonPath("$.shareId").value("AMZ"));
        
        actions.andExpect(jsonPath("$.shareName").exists());
        actions.andExpect(jsonPath("$.shareName").value("Amazon"));
        
        actions.andExpect(jsonPath("$.shareValue").exists());
        actions.andExpect(jsonPath("$.shareValue").value("2500.0"));
    }

 

    @Test
    public void testGetAllDailySharePrice() throws Exception {
        ResultActions actions = mvc.perform(get("/dailyAllSharePrice"));
        actions.andExpect(status().isOk());
        
    }
    
    
    @Test
    public void testGetDailySharePriceByIDList() throws Exception {
        ResultActions actions = mvc.perform(get("/dailySharePrice/AMZ"));
        actions.andExpect(status().isOk());
        
    }
}
 