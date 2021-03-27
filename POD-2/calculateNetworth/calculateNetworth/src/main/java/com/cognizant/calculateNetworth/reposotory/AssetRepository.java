package com.cognizant.calculateNetworth.reposotory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.calculateNetworth.model.Asset;

public interface AssetRepository extends JpaRepository<Asset,Integer>{
	public List<Asset> findByPortfolioidOrderByAssetid(int id);
	
	public Asset findByPortfolioidAndAssetidAndType(int portfolioId,String assetId,String type);
}
