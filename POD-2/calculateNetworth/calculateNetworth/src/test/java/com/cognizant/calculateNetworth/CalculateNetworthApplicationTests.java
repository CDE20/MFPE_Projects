package com.cognizant.calculateNetworth;

 

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

 

import com.cognizant.calculateNetworth.controller.StocksContoller;

 

@AutoConfigureMockMvc
@SpringBootTest
class CalculateNetworthApplicationTests {
    @Autowired
    private StocksContoller controller;

 

    @Autowired
    private MockMvc mvc;
    
    @Test
    void contextLoads() {
        assertNotNull(controller);
    }
    
    /*@Test
    public void testGetAsset() throws Exception {
        ResultActions actions = mvc.perform(get("/NetWorth/calculateNetworth/101"));
        actions.andExpect(status().isOk());
        
        //actions.andExpect(jsonPath("$.shareId").value("AMZ"));

 

    }*/

 

    @Test
    public void testGetAllMutualFunds() throws Exception {
        ResultActions actions = mvc.perform(get("/NetWorth/mutualfunds"));
        actions.andExpect(status().isOk());
        
    }
    
    
    @Test
    public void testGetStcokName() throws Exception {
        ResultActions actions = mvc.perform(get("/NetWorth//pershare/Amazon"));
        actions.andExpect(status().isOk());
        
    }

 

    @Test
    public void testGetAllStocks() throws Exception {
        ResultActions actions = mvc.perform(get("/NetWorth/shares"));
        actions.andExpect(status().isOk());
        
    }
}
 