package com.sunbeam.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.entities.PizzaItem;
import com.sunbeam.entities.PizzaPricing;
import com.sunbeam.models.PizzaAppResponse;
import com.sunbeam.services.PizzaMenuService;

@RequestMapping("/common")
@RestController
public class PizzaMenuRestController {
	private PizzaMenuService menuService;

	@Autowired
	public PizzaMenuRestController(PizzaMenuService menuService) {
		this.menuService = menuService;
	}

	@GetMapping("/items")
	public PizzaAppResponse<?> getAllItems() {
		List<PizzaItem> list = menuService.findAllItems();
		return PizzaAppResponse.success(list);
	}
	
	@GetMapping("/items/{id}")
	public PizzaAppResponse<?> getItemById(@PathVariable("id") int id) {
		PizzaItem item = menuService.findItemById(id);
		return PizzaAppResponse.success(item);
	}
	
	@GetMapping("/items/{id}/prices")
	public PizzaAppResponse<?> getItemPricesByItemId(@PathVariable("id") int id) {
		List<PizzaPricing> priceList = menuService.findItemPricesByItemId(id);
		return PizzaAppResponse.success(priceList);
	}
	
	@GetMapping("/itemprices/{priceId}")
	public PizzaAppResponse<?> getItemPriceById(@PathVariable("priceId") int priceId) {
		PizzaPricing item = menuService.findItemPriceById(priceId);
		return PizzaAppResponse.success(item);
	}

	@GetMapping("/itemtypes")
	public PizzaAppResponse<?> getAllItemTypes() {
		List<String> list = menuService.findAllItemTypes();
		return PizzaAppResponse.success(list);
	}

	@GetMapping("/itemcategories")
	public PizzaAppResponse<?> getAllItemCategories() {
		List<String> list = menuService.findAllItemCategories();
		return PizzaAppResponse.success(list);
	}
}
