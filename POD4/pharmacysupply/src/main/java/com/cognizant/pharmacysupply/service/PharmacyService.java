package com.cognizant.pharmacysupply.service;

import java.util.List;

import com.cognizant.pharmacysupply.exception.MedicineNotFoundException;
import com.cognizant.pharmacysupply.model.MedicineDemand;
import com.cognizant.pharmacysupply.model.PharmacyMedicineSupply;

public interface PharmacyService {
	public Boolean validateToken(String token) ;
	public List<PharmacyMedicineSupply> getMedicineSupply();
	public List<MedicineDemand> getMedicineDemand();
	public List<PharmacyMedicineSupply> getPharmacySupplyCount(String token, List<MedicineDemand> medicineDemandList) throws MedicineNotFoundException ;
}
