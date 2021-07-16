package com.cg.census.profile.CensusProfiling.secure.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.census.profile.CensusProfiling.model.AppUser;
import com.cg.census.profile.CensusProfiling.secure.repository.AppUserRepository;



@Service
public class AppUserService {

	private final static Logger log = LoggerFactory.getLogger(AppUserService.class);

	@Autowired
	private AppUserRepository repository;

	private AppUser currentAppUser; // access control to APIs

	public AppUser login(AppUser appUser) {
		log.info("loginService");
		currentAppUser = repository.findByUsername(appUser.getUsername());
		return currentAppUser;
	}

	public AppUser register(AppUser appUser) {
		log.info("registerService");
		return repository.save(appUser);
	}

	public String logout() {
		log.info("logoutService");
		currentAppUser = null;
		return "User logged out successfully";
	}

	public AppUser loginStatus() {
		log.info("loginStatusService");
		return currentAppUser;
	}

}
