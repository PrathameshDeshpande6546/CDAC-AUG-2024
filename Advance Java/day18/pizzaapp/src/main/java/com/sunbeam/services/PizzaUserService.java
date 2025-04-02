package com.sunbeam.services;

import com.sunbeam.entities.PizzaCustomer;
import com.sunbeam.models.Credentials;

public interface PizzaUserService {
	PizzaCustomer getCustomerByEmail(String email);

	PizzaCustomer getCustomerByCredentials(Credentials cr);
}
