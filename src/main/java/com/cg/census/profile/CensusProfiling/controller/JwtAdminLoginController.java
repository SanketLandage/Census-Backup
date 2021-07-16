package com.cg.census.profile.CensusProfiling.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.census.profile.CensusProfiling.config.JwtUtil;
import com.cg.census.profile.CensusProfiling.secure.model.AdminLoginDto;
import com.cg.census.profile.CensusProfiling.secure.service.AdminLoginService;

// Do not delete these commented out annotations, 
// they will be needed later in React app. 
//@CrossOrigin(origins = "http://localhost:4201")
//@CrossOrigin(origins = "*")

@RestController
public class JwtAdminLoginController {
	private final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private AdminLoginService userDetailsService;

	@PostMapping("/login")
	public String login(@RequestBody AdminLoginDto myUser) {
		log.info("login");
		if (myUser.getUsername().equals(userDetailsService.loadUserByUsername(myUser.getUsername()).getUsername())
				&& myUser.getPassword().equals(userDetailsService.loadUserByUsername(null).getPassword())) {
			log.info("user authenticated");
			return jwtTokenUtil.generateToken(userDetailsService.loadUserByUsername(myUser.getUsername()));
		} else {
			return "thisIsNotTheValidToken";
		}

	}
}