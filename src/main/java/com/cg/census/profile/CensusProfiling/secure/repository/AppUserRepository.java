package com.cg.census.profile.CensusProfiling.secure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.census.profile.CensusProfiling.model.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Integer> {

	public abstract AppUser findByUsername(String username);

}