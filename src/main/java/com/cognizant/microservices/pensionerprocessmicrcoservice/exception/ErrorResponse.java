package com.cognizant.microservices.pensionerprocessmicrcoservice.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ErrorResponse {
	
	private String message;
	private int statusCode;
	private Long exceptionTime;


}
