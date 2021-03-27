package com.cognizant.medicinestock.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "medicine_stock")
@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class MedicineStock {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String chemicalComposition;
	private String targetAilment;
	private String pharmacyName;
	@Temporal(TemporalType.DATE)
	private Date dateOfExpiry;
	private int numberOfTabletsInStock;

	



}
