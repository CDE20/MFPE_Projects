package com.pensionManagementSystem.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class PensionerInput {
	private String name;
	
	private @DateTimeFormat(pattern="yyyy-MM-dd") Date dateOfBirth;
	private String pan;
	private long aadharNumber;
	private String pensionType;

}
