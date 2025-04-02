package com.sunbeam.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeam.daos.PizzaCustomerDao;
import com.sunbeam.daos.PizzaOrderDao;
import com.sunbeam.entities.PizzaCustomer;
import com.sunbeam.entities.PizzaOrder;
import com.sunbeam.entities.PizzaOrderDetail;
import com.sunbeam.entities.PizzaPricing;

@Transactional
@Service
public class PizzaOrderServiceImpl implements PizzaOrderService {
	private PizzaOrderDao orderDao;
	private PizzaCustomerDao custDao;
	
	@Autowired
	public PizzaOrderServiceImpl(PizzaOrderDao orderDao, PizzaCustomerDao custDao) {
		this.orderDao = orderDao;
		this.custDao = custDao;
	}

	@Override
	public PizzaOrder saveOrder(int custId, List<Integer> priceIdList) {
		//PizzaCustomer cust = new PizzaCustomer();
		//cust.setId(custId);
		PizzaCustomer cust = custDao.findById(custId).get();
		List<PizzaOrderDetail> priceList = new ArrayList<PizzaOrderDetail>();
		PizzaOrder order = new PizzaOrder(0, LocalDateTime.now(), "Pending", cust, priceList);
		for (int priceId : priceIdList) {
			PizzaPricing itemPrice = new PizzaPricing(priceId, "", 0.0, null);
			//PizzaPricing itemPrice = pricingDao.findById(priceId).get();
			PizzaOrderDetail detail = new PizzaOrderDetail(0, itemPrice , order);
			priceList.add(detail);
		}
		PizzaOrder dbOrder = orderDao.save(order);
		return dbOrder;
	}
}
