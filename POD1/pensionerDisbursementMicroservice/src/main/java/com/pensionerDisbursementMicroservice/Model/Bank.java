package com.pensionerDisbursementMicroservice.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Bank {
	private String name;
	private int acctno;
	private String bankType;
	
}
