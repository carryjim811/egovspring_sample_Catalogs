package com.dkpia.catalogs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.dkpia.catalogs.service.CustomerApiService;

@RestController
@RequestMapping("/catalogs/customerinfo")
public class CatalogsController {
	
	@Autowired
	private CustomerApiService customerApiService;
	
	@GetMapping(path = "/{customerId}")
	public String getCustomerInfo(@PathVariable String customerId) {
		String customerInfo = customerApiService.getCustomerDetail(customerId);
		System.out.println("response customerInfo : " + customerInfo);
		return String.format("[Customer id = %s at %s %s ]", customerId, System.currentTimeMillis(), customerInfo);
	}
}
