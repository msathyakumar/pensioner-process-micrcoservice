package com.cognizant.microservices.pensionerprocessmicrcoservice.models;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProcessPensionReponse {

	private String aadhaarNumber;
	private double pensionAmount;
	

}
