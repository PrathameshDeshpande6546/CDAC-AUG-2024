package com.sunbeam.services;

import java.util.List;

import com.sunbeam.entities.PizzaOrder;

public interface PizzaOrderService {
	PizzaOrder saveOrder(int custId, List<Integer> priceIdList);
}
