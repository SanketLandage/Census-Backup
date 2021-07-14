package com.cg.census.profile.CensusProfiling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.census.profile.CensusProfiling.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin , Integer>{

}
