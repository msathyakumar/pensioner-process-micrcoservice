package com.cognizant.microservices.pensionerprocessmicrcoservice.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cognizant.microservices.pensionerprocessmicrcoservice.models.PensionerDetail;


@Service                                                                           
public class PensionCalculations {
	public static final Logger LOGGER = LoggerFactory.getLogger(PensionCalculations.class);
	
	public double bankcharge(PensionerDetail pensionerDetail) {
		double pensionAmount = 0;
		if (pensionerDetail.getPensionType().equalsIgnoreCase("self")) {
			pensionAmount = 0.8 * pensionerDetail.getSalary() + pensionerDetail.getAllowance();
		} else if (pensionerDetail.getPensionType().equalsIgnoreCase("family")) {
			pensionAmount = 0.5 * pensionerDetail.getSalary() + pensionerDetail.getAllowance();
		}
		LOGGER.info("END - calculatePension");
		return pensionAmount;
	}
	






public double inputBankCharge(String bankType) {

	LOGGER.info("STARTED - inputBankCharge");
	double charge =0;
	if (bankType.equalsIgnoreCase("private")) {
		;
		charge= 550;
		} else {
			LOGGER.info("END - inputBankCharge - private - false");
			
		}
	
	if (bankType.equalsIgnoreCase("public")) {
	
			LOGGER.info("END - inputBankCharge - public - true");
			charge= 500;
		}
		
	return charge;
	
}
}
