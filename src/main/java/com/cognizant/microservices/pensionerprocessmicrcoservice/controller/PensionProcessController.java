package com.cognizant.microservices.pensionerprocessmicrcoservice.controller;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.microservices.pensionerprocessmicrcoservice.authclient.PensionerDetailClient;
import com.cognizant.microservices.pensionerprocessmicrcoservice.models.PensionDetail;
import com.cognizant.microservices.pensionerprocessmicrcoservice.models.PensionerDetail;
import com.cognizant.microservices.pensionerprocessmicrcoservice.models.PensionerInput;
import com.cognizant.microservices.pensionerprocessmicrcoservice.models.ProcessPensionReponse;
import com.cognizant.microservices.pensionerprocessmicrcoservice.services.PensionCalculations;



@RestController
@CrossOrigin(origins = "*")
public class PensionProcessController {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(PensionProcessController.class);
	
	@Autowired
	PensionerDetailClient pensionerDetailClient;
	
	@Autowired
	private PensionCalculations pensionCalculation;
	
	@PostMapping("/processPension")
	public ProcessPensionReponse getStatusCode(@RequestHeader(name = "Authorization") String token,
			@RequestBody PensionerInput processPensionInput) {
		
		LOGGER.info("STARTED - getStatusCode");
		LOGGER.info("STARTED - getStatusCode"+token);
		LOGGER.info("STARTED - getStatusCode"+processPensionInput.toString());
		PensionerDetail pensionerDetail = pensionerDetailClient.findByAadhaarNumber(token,processPensionInput.getAadhaarNumber());
		LOGGER.info("END - getStatusCode");
		double bankcharge = pensionCalculation.bankcharge(pensionerDetail)-pensionCalculation.inputBankCharge(pensionerDetail.getBank().getBankType());
		
		return new ProcessPensionReponse(pensionerDetail.getName(), pensionerDetail.getAadhaarNumber(),bankcharge);
		//return new ProcessPensionReponse(pensionerDetail.getAadhaarNumber(),pensionerDetail.getSalary());
		//return pensionDisbursementClient.getPensionDisbursement(token, processPensionInput);
	}
	@PostMapping("/pensionDetail")
	public PensionerDetail getpensionerDetail(@RequestHeader(name = "Authorization") String token,
			@RequestBody PensionerInput processPensionInput) {
		
		LOGGER.info("STARTED - getStatusCode");
		PensionerDetail pensionerDetail = pensionerDetailClient.findByAadhaarNumber(token,processPensionInput.getAadhaarNumber());
		LOGGER.info("END - getStatusCode");
		//double bankcharge = pensionCalculation.bankcharge(pensionerDetail)-pensionCalculation.inputBankCharge(pensionerDetail.getBank().getBankType());
		
		return pensionerDetail;
		//return new ProcessPensionReponse(pensionerDetail.getAadhaarNumber(),pensionerDetail.getSalary());
		//return pensionDisbursementClient.getPensionDisbursement(token, processPensionInput);
	}
	
	
	
	@GetMapping("/details")
	public List<PensionerDetail> allDetail() {
		LOGGER.info("STARTED - allDetail");
		List<PensionerDetail> pensionerDetail = pensionerDetailClient.getAllDetail();
		LOGGER.info("END - allDetail");
		return pensionerDetail;
	}

}
