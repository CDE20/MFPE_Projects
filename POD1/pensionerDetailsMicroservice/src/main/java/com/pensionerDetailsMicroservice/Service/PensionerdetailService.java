package com.pensionerDetailsMicroservice.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.pensionerDetailsMicroservice.Exception.NotFoundException;
import com.pensionerDetailsMicroservice.Model.Bank;
import com.pensionerDetailsMicroservice.Model.PensionerDetail;
import com.pensionerDetailsMicroservice.Util.DateUtil;

@Service
public class PensionerdetailService {

	private Map<Long, PensionerDetail> pensionDetails;

	public PensionerDetail getPensionerDetailByAadhaarNumber(long aadhaarNumber)
			throws IOException, NotFoundException, NumberFormatException, ParseException {
		String line = "";
		pensionDetails = new HashMap<>();
		BufferedReader br = new BufferedReader(
				new InputStreamReader(this.getClass().getResourceAsStream("/details.csv")));
		while ((line = br.readLine()) != null) // returns a Boolean value
		{
			String[] person = line.split(",");
			PensionerDetail pd = new PensionerDetail(person[1], DateUtil.parseDate(person[2]), person[3],
					Double.parseDouble(person[4]), Double.parseDouble(person[5]), person[6],
					new Bank(person[7], Long.parseLong(person[8]), person[9]));
			pensionDetails.put(Long.parseLong(person[0]), pd);
		}

		if (pensionDetails.containsKey(aadhaarNumber)) {
			return pensionDetails.get(aadhaarNumber);
		} else {
			throw new NotFoundException("AadharNumber Not Found");
		}
	}

}
