package com.cognizant.pharmacysupply.model;

import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MedicineStock {
	
	
	private int id;
	@NotEmpty(message = "Medicine name is required")
	private String name;
	@NotEmpty(message = "Chemical composition  is required")
	private String chemicalComposition;
	@NotEmpty(message = "Target ailment is required")
	private String targetAilment;
	@NotEmpty(message = "Pharmacy name is required")
	private String pharmacyName;
	@Future
	private Date dateOfExpiry;
	@Min(value = 1, message = "Number of tablet must be greater than zero")
	private int numberOfTabletsInStock;
	
	
	


}
