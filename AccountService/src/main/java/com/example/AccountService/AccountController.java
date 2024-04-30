package com.example.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AccountController {
	@Autowired
	private RestTemplate template;

	@GetMapping("/account-payment/{price}")
	public String invokePaymentService(@PathVariable int price) {
		String url = "http://FEESERVICE/Fee-provider/payNow/" + price;
		return template.getForObject(url, String.class);
	}
}
