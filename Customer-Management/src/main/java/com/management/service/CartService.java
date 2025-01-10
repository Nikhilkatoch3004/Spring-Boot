package com.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.model.Cart;
import com.management.repository.CartRepository;

@Service
public class CartService {
	
	@Autowired
	CartRepository cartRepository ;

	public void saveCart(Cart cart) {
		
		
		cartRepository.save(cart);
	}

}
