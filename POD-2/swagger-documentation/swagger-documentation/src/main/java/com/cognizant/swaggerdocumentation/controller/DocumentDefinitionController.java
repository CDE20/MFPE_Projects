package com.cognizant.swaggerdocumentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.swaggerdocumentation.config.ServiceDefinitionsContext;

@RestController
public class DocumentDefinitionController {

    @Autowired
    private ServiceDefinitionsContext definitionContext;

    @GetMapping("/service/{servicename}")
    public String getServiceDefinition(@PathVariable("servicename") String serviceName){
        return definitionContext.getSwaggerDefinition(serviceName);
    }
}
