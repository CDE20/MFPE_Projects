package com.cognizant.pharmacysupply.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.pharmacysupply.model.MedicineStock;

/*
 * This Feign Client connects to medicine-stock-service present at port 8081
 */

@FeignClient(url = "http://ec2-34-232-69-235.compute-1.amazonaws.com:8081", name = "medicine-stock-service")
public interface MedicineStockFeignClient {
	
	/*
	 * Method Name --> getNumberOfTabletsInStockByName
	 * @param      --> medicine name
	 * @return     --> supply count 
	*/
	@PostMapping("/api/medicine-stock/get-stock-count/{medicine}")
	public MedicineStock getNumberOfTabletsInStockByName(@RequestHeader(name = "Authorization") String token,@PathVariable("medicine") String medicine);
	
	/*
	 * Method Name --> updateNumberOfTabletsInStockByName
	 * @param      --> medicine 
	 * @param      --> count
	 * @return     --> boolean value to show successful or unsuccessful update 
	*/
	@PostMapping("/api/medicine-stock/update-stock/{medicine}/{count}")
	public Boolean updateNumberOfTabletsInStockByName(@RequestHeader(name = "Authorization") String token,@PathVariable("medicine") String medicine, @PathVariable("count") int count);	
}
