package com.pensionerDetailsMicroservice.Controller;

import java.io.IOException;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pensionerDetailsMicroservice.Exception.NotFoundException;
import com.pensionerDetailsMicroservice.Model.PensionerDetail;
import com.pensionerDetailsMicroservice.Service.PensionerdetailService;

@RestController
public class PensionerDetailsController {

	@Autowired
	private PensionerdetailService pds;

	@PostMapping("/pensionerDetailByAadhaar/{aadhaarNumber}")
	public PensionerDetail getPensionerDetailByAadhaar(@PathVariable long aadhaarNumber ) {

		try {
			return pds.getPensionerDetailByAadhaarNumber(aadhaarNumber);
		} catch (NumberFormatException | IOException | NotFoundException | ParseException e) {
			return null;
		}

	}
}
