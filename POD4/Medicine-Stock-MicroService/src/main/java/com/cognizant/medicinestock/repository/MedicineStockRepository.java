package com.cognizant.medicinestock.repository;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.medicinestock.model.MedicineStock;

@Repository
public interface MedicineStockRepository extends JpaRepository<MedicineStock, String>{

	
	@Query(name = "select * from medicine_stock where target_ailment = :targetAilment", nativeQuery = true)
	List<MedicineStock> getMedicineByTargetAilment(@PathParam("targetAilment") String targetAilment);
	
	@Query(name = "SELECT NUMBER_OF_TABLETS_IN_STOCK FROM MEDICINE_STOCK where NAME = :medicine", nativeQuery = true)
	MedicineStock getNumberOfTabletsInStockByName(@PathParam("medicine") String medicine);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE MEDICINE_STOCK M SET M.NUMBER_OF_TABLETS_IN_STOCK =?2 where M.NAME =?1", nativeQuery = true)
	void updateNumberOfTabletsInStockByName(String medicine, int count);

}
