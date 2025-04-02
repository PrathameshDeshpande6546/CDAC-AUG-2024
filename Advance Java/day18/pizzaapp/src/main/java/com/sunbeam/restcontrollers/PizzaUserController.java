package com.sunbeam.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.entities.PizzaCustomer;
import com.sunbeam.models.Credentials;
import com.sunbeam.models.PizzaAppResponse;
import com.sunbeam.security.JwtUtil;
import com.sunbeam.services.PizzaUserService;

@RestController
public class PizzaUserController {
	private PizzaUserService userService;
	@Autowired
	private AuthenticationManager authManager;
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	public PizzaUserController(PizzaUserService userService) {
		this.userService = userService;
	}

	@PostMapping("/authenticate")
	public ResponseEntity<?> authenticate(@RequestBody Credentials cr) {
		// authenticate user with authentication manager		
		Authentication auth = new UsernamePasswordAuthenticationToken(cr.getEmail(), cr.getPassword());
		System.out.println("BEFORE AUTH: " + auth);
		auth = authManager.authenticate(auth);
		System.out.println("AFTER AUTH: " + auth);
		// after authentication, create JWT token and return.
		String token = jwtUtil.createToken(auth);
		return ResponseEntity.ok(token);
	}
}
