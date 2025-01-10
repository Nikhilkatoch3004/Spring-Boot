package com.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.management.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart , Long> {

}
