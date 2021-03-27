package com.cognizant.medicinestock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.medicinestock.model.MedicineStock;
import com.cognizant.medicinestock.repository.MedicineStockRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MedicineStockServiceImpl implements MedicineStockService{

	@Autowired
	private MedicineStockRepository repository;
	
	@Override
	public List<MedicineStock> getMedicineStockInformation() {
		log.info("START");
		log.info("END");
		return repository.findAll();
	}
	
	@Override
	public List<MedicineStock> getMedicineByTargetAilment(String treatingAilment) {
		log.info("START");
		log.info("END");
		return repository.getMedicineByTargetAilment(treatingAilment);
	}
	
	@Override
	public MedicineStock getNumberOfTabletsInStockByName(String medicine) {
		log.info("START");
		log.info("END");
		MedicineStock numberOfTabletsInStockByName = repository.getNumberOfTabletsInStockByName(medicine);
		log.debug("NUMBER OF TABLETS IN STOCK BY NAME {}:", numberOfTabletsInStockByName);
		return numberOfTabletsInStockByName;
	}

	@Override
	public Boolean updateNumberOfTabletsInStockByName(String medicine, int count) {
		log.info("START");
		log.info(medicine + " ############# " + count);
		repository.updateNumberOfTabletsInStockByName(medicine, count);
		log.info("END");
		return true;
	}

}
