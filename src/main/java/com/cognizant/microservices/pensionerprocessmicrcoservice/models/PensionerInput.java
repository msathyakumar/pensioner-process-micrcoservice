package com.cognizant.microservices.pensionerprocessmicrcoservice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PensionerInput {

	private String name;
	private String dateOfBirth;
	private String panNumber;
	private String aadhaarNumber;
	private String pensionType;

}
