package com.sunbeam.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.PizzaOrder;

public interface PizzaOrderDao extends JpaRepository<PizzaOrder, Integer> {
	
}
