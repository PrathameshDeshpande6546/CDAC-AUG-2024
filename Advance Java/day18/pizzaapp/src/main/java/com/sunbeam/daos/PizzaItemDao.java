package com.sunbeam.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sunbeam.entities.PizzaItem;

public interface PizzaItemDao extends JpaRepository<PizzaItem, Integer> {
	@Query("SELECT DISTINCT pi.type FROM PizzaItem pi")
	List<String> findMenuTypes();
	@Query("SELECT DISTINCT pi.category FROM PizzaItem pi")
	List<String> findMenuCategories();
}
