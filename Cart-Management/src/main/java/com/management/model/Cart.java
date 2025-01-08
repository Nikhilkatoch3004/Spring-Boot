package com.management.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cartId;

	@Column(nullable = false)
	private String productName;

	@Column(nullable = false)
	private double price;

	@OneToOne(mappedBy = "cart")
	@JsonBackReference
	private Customer customer;

	public Cart(Long cartId, String productName, double price, Customer customer) {
		super();
		this.cartId = cartId;
		this.productName = productName;
		this.price = price;
		this.customer = customer;
	}

	public Cart() {
	}

	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Cart{" + 
				"cartId=" + cartId + 
				", productName='" + productName + '\'' + 
				", price=" + price + 
				'}';
	}

}
