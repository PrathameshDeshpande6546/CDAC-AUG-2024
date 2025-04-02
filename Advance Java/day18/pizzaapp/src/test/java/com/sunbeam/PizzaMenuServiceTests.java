package com.sunbeam;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.entities.PizzaItem;
import com.sunbeam.services.PizzaMenuService;

@SpringBootTest
class PizzaMenuServiceTests {
	@Autowired
	private PizzaMenuService menuService;
	@Transactional
	@Test
	void testFindAllItems() {
		List<PizzaItem> list = menuService.findAllItems();
		for (PizzaItem item : list) {
			System.out.println("**" + item);
			item.getPriceList().forEach(System.out::println);
		}
		assertThat(list).isNotEmpty();
	}
}
