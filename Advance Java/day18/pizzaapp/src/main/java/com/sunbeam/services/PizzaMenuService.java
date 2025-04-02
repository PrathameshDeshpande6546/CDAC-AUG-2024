package com.sunbeam.services;

import java.util.List;

import com.sunbeam.entities.PizzaItem;
import com.sunbeam.entities.PizzaPricing;

public interface PizzaMenuService {
	List<PizzaItem> findAllItems();

	List<String> findAllItemTypes();

	List<String> findAllItemCategories();

	PizzaItem findItemById(int id);

	PizzaPricing findItemPriceById(int priceId);

	List<PizzaPricing> findItemPricesByItemId(int id);
}
