package com.management.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false, unique = false)
	private String firstName;

	@Column(nullable = false, unique = false)
	private String lastName;

	@Column(nullable = false, unique = true)
	private String password;

	@Column(nullable = false, unique = false)
	private LocalDate dob;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cart_Id", referencedColumnName = "cartId")
//	@JsonBackReference
	private Cart cart;

	public Customer(Long id, String email, String firstName, String lastName, String password, LocalDate dob,
			Cart cart) {
		super();
		this.id = id;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.dob = dob;
		this.cart = cart;
	}

	public Customer() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	@Override
	public String toString() {
		return "Customer{" + 
				"id=" + id + 
				", email='" + email + '\'' + 
				", firstName='" + firstName + '\''
				+ ", lastName='" + lastName + '\'' + 
				", dob=" + dob + 
				'}';
	}
}
