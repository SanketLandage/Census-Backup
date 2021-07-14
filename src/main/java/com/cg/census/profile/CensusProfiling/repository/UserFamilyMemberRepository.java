package com.cg.census.profile.CensusProfiling.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.census.profile.CensusProfiling.model.UserFamilyMember;

@Repository
public interface UserFamilyMemberRepository extends JpaRepository<UserFamilyMember, Integer> {
	// public abstract List<User> findByfirstName(String firstName);
	public abstract Long deleteBymemFirstName(String name);

	public abstract List<UserFamilyMember> findBymemId(int mid);

	public abstract List<UserFamilyMember> findBymemFirstName(String memFirstName);

	public abstract List<UserFamilyMember> findBymemLastName(String memLastName);

	public abstract List<UserFamilyMember> findByrelation(String relation);

	public abstract List<UserFamilyMember> findBydob(String dob);
}
