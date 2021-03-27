package com.cognizant.portfolio_management.DailyMutualFundNAV.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cognizant.portfolio_management.DailyMutualFundNAV.model.MutualFund;

public interface MutualFundRepository extends JpaRepository<MutualFund,String>{
	
	public List<MutualFund> findAll();
	
	public MutualFund findByMutualFundName(String mutualFundName);
	

	 @Query("SELECT m FROM MutualFund m WHERE m.mutualFundId IN (:mutualFundIdList) order by m.mutualFundId")
	public List<MutualFund> findByMutualFundId(@Param("mutualFundIdList") List<String> mutualFundIdList);
	
	
 
}
