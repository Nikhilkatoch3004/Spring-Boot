package com.management.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.management.exception.CustomerNotFoundException;
import com.management.model.Customer;
import com.management.repository.CustomerRepository;

@Service
public class CustomerService implements UserDetailsService {
	
	@Autowired
	private CustomerRepository customerRepository ;
	
	@Autowired
	private PasswordEncoder passwordEncoder ;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<Customer> cust = customerRepository.findByEmail(email);
		return cust.orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
	}

	public void saveUser(Customer customer) {
		customerRepository.save(customer);
		
	}
	

}
