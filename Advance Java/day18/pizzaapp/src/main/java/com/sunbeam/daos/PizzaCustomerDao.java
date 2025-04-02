package com.sunbeam.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.PizzaCustomer;

public interface PizzaCustomerDao extends JpaRepository<PizzaCustomer, Integer> {
	PizzaCustomer findByEmail(String email);
}
