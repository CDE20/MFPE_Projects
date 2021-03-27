package com.rulesservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

//The output format for serviceCharges
public class ServiceResponse {
   private String message;
   private long accountId;
   private Double balance;
    
}
