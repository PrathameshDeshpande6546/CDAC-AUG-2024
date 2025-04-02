package com.sunbeam.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.PizzaPricing;

public interface PizzaPricingDao extends JpaRepository<PizzaPricing, Integer> {

}
