package com.sunbeam.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.PizzaOrderDetail;

public interface PizzaOrderDetailsDao extends JpaRepository<PizzaOrderDetail, Integer> {
	
}
