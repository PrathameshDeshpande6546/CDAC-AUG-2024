package com.sunbeam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.daos.PizzaItemDao;
import com.sunbeam.daos.PizzaPricingDao;
import com.sunbeam.entities.PizzaItem;
import com.sunbeam.entities.PizzaPricing;

@Transactional
@Service
public class PizzaMenuServiceImpl implements PizzaMenuService {
	private PizzaItemDao itemDao;
	private PizzaPricingDao pricingDao;
	
	@Autowired
	public PizzaMenuServiceImpl(PizzaItemDao itemDao, PizzaPricingDao pricingDao) {
		this.itemDao = itemDao;
		this.pricingDao = pricingDao;
	}
	
	@Override
	public List<PizzaItem> findAllItems() {
		List<PizzaItem> list = itemDao.findAll();
		return list;
	}
	@Override
	public List<String> findAllItemTypes() {
		List<String> list = itemDao.findMenuTypes();
		return list;
	}
	@Override
	public List<String> findAllItemCategories() {
		List<String> list = itemDao.findMenuCategories();
		return list;
	}
	
	@Override
	public PizzaItem findItemById(int id) {
		Optional<PizzaItem> item = itemDao.findById(id);
		return item.get();
	}
	
	@Override
	public PizzaPricing findItemPriceById(int priceId) {
		Optional<PizzaPricing> itemPrice = pricingDao.findById(priceId);
		return itemPrice.get();
	}
	
	@Override
	public List<PizzaPricing> findItemPricesByItemId(int id) {
		Optional<PizzaItem> item = itemDao.findById(id);
		return item.get().getPriceList();
	}
}
