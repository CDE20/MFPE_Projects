package com.cognizant.portal.model;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "medicine_supply")
public class MedicineSupply {


	@JsonIgnore
	private int id;

	private String pharmacyName;

	private String medicineName;

	private int supplyCount;
}