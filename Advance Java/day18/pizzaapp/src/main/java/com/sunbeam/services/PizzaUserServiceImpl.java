package com.sunbeam.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sunbeam.daos.PizzaCustomerDao;
import com.sunbeam.entities.PizzaCustomer;
import com.sunbeam.models.Credentials;

@Service
public class PizzaUserServiceImpl implements PizzaUserService, UserDetailsService {
	private PizzaCustomerDao userDao;
	@Autowired
	public PizzaUserServiceImpl(PizzaCustomerDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public PizzaCustomer getCustomerByEmail(String email) {
		PizzaCustomer dbCust = userDao.findByEmail(email);
		return dbCust;
	}
	
	@Override
	public PizzaCustomer getCustomerByCredentials(Credentials cr) {
		PizzaCustomer dbCust = userDao.findByEmail(cr.getEmail());
		if(dbCust != null && dbCust.getPassword().equals(cr.getPassword()))
			return dbCust;
		return null;
	}
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		PizzaCustomer dbUser = userDao.findByEmail(email);
		if(dbUser == null)
			throw new UsernameNotFoundException("No user exists!");
		return dbUser;
	}
}
