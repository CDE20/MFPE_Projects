package com.cognizant.calculateNetworth.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.calculateNetworth.model.Asset;
import com.cognizant.calculateNetworth.reposotory.AssetRepository;

@Service
public class AssetService {
	
	@Autowired
	private AssetRepository repository;
	
	
	@Transactional
	public List<Asset> getAllAssetForPortfolio(int id){
		return repository.findByPortfolioidOrderByAssetid(id);
	}
	
	
 
}
