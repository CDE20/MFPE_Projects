package com.cognizant.portfolio_management.DailySharePrice.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cognizant.portfolio_management.DailySharePrice.model.ShareDetails;

public interface ShareRepository extends JpaRepository<ShareDetails,String>{
	
	public List<ShareDetails> findAll();
	
	public ShareDetails findByShareName(String shareName);

	public ShareDetails findByShareId(String shareId);
	
	 @Query("SELECT s FROM ShareDetails s WHERE s.shareId IN (:shareID) order by s.shareId")
	public List<ShareDetails> findByShareId(@Param("shareID") List<String> shareId);
 
}
