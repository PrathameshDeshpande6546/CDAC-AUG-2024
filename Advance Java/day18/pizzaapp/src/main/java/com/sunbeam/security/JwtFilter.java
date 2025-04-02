package com.sunbeam.security;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.sunbeam.daos.PizzaCustomerDao;
import com.sunbeam.entities.PizzaCustomer;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter {
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private PizzaCustomerDao custDao;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// PRE-PROCESSING
		// get jwt token from request header
		String authHeader = request.getHeader("Authorization");
		boolean validHeader = authHeader != null && authHeader.startsWith("Bearer");
		Authentication auth = null;
		if (validHeader) {
			String token = authHeader.replace("Bearer", "").trim();
			// validate that jwt token and create Authentication object
			String subject = jwtUtil.validateToken(token);
			// verify details from the token
			int custId = Integer.parseInt(subject);
			PizzaCustomer user = custDao.findById(custId).get();
			auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
		}
		
		//  attach auth/principal to current security context
		if (auth != null && SecurityContextHolder.getContext().getAuthentication() == null)
			SecurityContextHolder.getContext().setAuthentication(auth);
		
		// invoke next filter in the chain
		filterChain.doFilter(request, response);
		
		// POST-PROCESSING (nothing to do here)
	}

}
