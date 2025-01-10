package com.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.management.model.Cart;
import com.management.model.Customer;
import com.management.service.CartService;
import com.management.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private CartService cartService ;
	
	@Autowired private PasswordEncoder passwordEncoder;

	@PostMapping("/register")
	private ResponseEntity<String> registerCustomer(@Validated @RequestBody Customer customer){
		Cart cart = customer.getCart(); 
	
	if (cart != null) { cartService.saveCart(cart); 
	} 
	customer.setPassword(passwordEncoder.encode(customer.getPassword()));
	customerService.saveUser(customer); return new ResponseEntity<>("User Registered Successfully", HttpStatus.OK);
	}

	@PostMapping("/login")
	public ResponseEntity<String> customerLogin(@RequestBody Customer customer) {
		try {
			Authentication authentication = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(customer.getEmail(), customer.getPassword()));
			String email = authentication.getName();
			System.out.println("Customer" + email + " Has been Authenticated");

			return new ResponseEntity<String>("Customer Logged In Successfully", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Invalid Email or password", HttpStatus.UNAUTHORIZED);
		}
	}

	@GetMapping("/test")
	public ResponseEntity<String> getUsers() {
		return new ResponseEntity<>("Secure Data - Accessible Only to Authenticated Users", HttpStatus.OK);
	}
}
