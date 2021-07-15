package com.cg.census.profile.CensusProfiling.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.census.profile.CensusProfiling.SecureConfig.JwtUtil;
import com.cg.census.profile.CensusProfiling.model.AppUser;
import com.cg.census.profile.CensusProfiling.service.AppUserService;

// Do not delete these commented out annotations, 
// they will be needed later in React app. 
//@CrossOrigin(origins = "http://localhost:4201")
//@CrossOrigin(origins = "*")

@RestController
public class JWTUserController {
	private final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private AppUserService userDetailsService;

	@PostMapping("/login")
	public String login(@RequestBody AppUser myUser) {
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
