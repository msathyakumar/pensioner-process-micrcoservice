package com.cognizant.microservices.pensionerprocessmicrcoservice.authclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
//@FeignClient(name = "authorizationService",url = "http://localhost:9090")
@FeignClient(name = "authorizationService",url = "${AUTHSERVICEURL:http://localhost:9090}")
public interface AuthorizationClient {
	
	@GetMapping("/authorize")
	public Boolean authorization(@RequestHeader("Authorization") String token);
	

}
