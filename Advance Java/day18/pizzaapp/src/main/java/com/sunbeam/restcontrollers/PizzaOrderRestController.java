package com.sunbeam.restcontrollers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.entities.PizzaCustomer;
import com.sunbeam.entities.PizzaOrder;
import com.sunbeam.models.PizzaAppResponse;
import com.sunbeam.services.PizzaOrderService;

@RestController
public class PizzaOrderRestController {
	private PizzaOrderService orderService;
	@Autowired
	public PizzaOrderRestController(PizzaOrderService orderService) {
		this.orderService = orderService;
	}

	@PostMapping("/cust/orders")
	public PizzaAppResponse<?> placeOrder(Principal prn, @RequestBody List<Integer> priceIdList) {
		UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) prn;
		PizzaCustomer user = (PizzaCustomer) auth.getPrincipal();
		PizzaOrder dbOrder = orderService.saveOrder(user.getId(), priceIdList);
		return PizzaAppResponse.success(dbOrder);
	}
}
