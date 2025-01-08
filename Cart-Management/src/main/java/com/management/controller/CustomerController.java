package com.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.management.model.Customer;
import com.management.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@PostMapping("/register")
	private ResponseEntity<String> registerCustomer(@Validated @RequestBody Customer customer) {
		try {
			Customer cust = customerService.addCustomer(customer);

			if (cust != null) {
				return new ResponseEntity<String>("Customer Registered Successfully", HttpStatus.OK);
			} else {
				return ResponseEntity.badRequest().body("Registeration Unsuccessfull");
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An Error Occurred" + e.getMessage());
		}
	}

	@GetMapping("/view")
	public ResponseEntity<List<Customer>> viewCustomers() {

		List<Customer> cust = customerService.viewCustomer();
		if (cust != null) {
			return new ResponseEntity<List<Customer>>(cust, HttpStatus.OK);
		}
		return new ResponseEntity("NO DATA FOUND", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@PostMapping("/login")
	public ResponseEntity<String> loginCustomer(@Validated @RequestBody Customer customer) {

		String e = customer.getEmail();
		String p = customer.getPassword();

		Customer cust = customerService.get(e);

		if (cust == null) {
			throw new RuntimeException("Customer with Email " + e + " does not exist");
		}
		
		if (e.equals(cust.getEmail()) && p.equals(cust.getPassword())) {
			return ResponseEntity.status(HttpStatus.OK).body("Login Successfull");
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Login Unsuccessfull");
		}

	}

}
