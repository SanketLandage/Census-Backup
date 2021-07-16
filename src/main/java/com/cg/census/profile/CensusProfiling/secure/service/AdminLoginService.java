package com.cg.census.profile.CensusProfiling.secure.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
//@PropertySource("classpath:application.properties")
public class AdminLoginService implements UserDetailsService {

	private final static Logger log = LoggerFactory.getLogger(AdminLoginService.class);
	
//	@Autowired
//	private Environment environment;

	// Option 1. hard-code user credentials here
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		log.info("loadUserByUsername");
		return new User("census", "census", new ArrayList<>());
	}

//	 Option 2. fetch user credentials from application.properties file 
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		log.info("loadUserByUsername");
//		return new User(environment.getProperty("appUser.name"), environment.getProperty("appUser.password"),
//				new ArrayList<>());
//	}
}