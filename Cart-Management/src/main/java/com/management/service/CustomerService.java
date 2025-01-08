package com.management.service;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.management.model.Customer;
import com.management.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	private String encodePassword(String password) { // Encode password using Base64
		return Base64.getEncoder().encodeToString(password.getBytes());
	}

	private String decodePassword(String encodedPassword) { // Decode password using Base64

		return new String(Base64.getDecoder().decode(encodedPassword));
	}

	public Customer addCustomer(Customer customer) {
		
		customer.setPassword(encodePassword(customer.getPassword()));
		return customerRepository.save(customer);
	}

	public List<Customer> viewCustomer() {
			
		List<Customer> customer = customerRepository.findAll();
		String p = "********";
		for(Customer c : customer) {
			c.setPassword(p);
		}
		
		return customer;
	}

	public Customer get(String e) {
		Optional<Customer> c = customerRepository.findByEmail(e);
		if(c.isPresent()) {
			Customer cust = c.get() ;
			cust.setPassword(decodePassword(cust.getPassword()));
			return cust ;
		}
		return null;
	}

}
