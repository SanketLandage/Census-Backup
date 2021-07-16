package com.cg.census.profile.CensusProfiling.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.census.profile.CensusProfiling.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	public abstract List<User> findByfirstName(String firstName);

	public abstract List<User> findUserByFirstName(String firstName);

	public abstract List<User> findUserByLastName(String lastName);

	public abstract List<User> findUserByGender(String gender);

	public abstract List<User> findUserByEmail(String email);

	public abstract List<User> findUserBycity(String city);

	public abstract User findByuid(int uid);

	public abstract Object deleteAllByuid(int uid);

	public abstract List<User> findUserByage(int age);

	public abstract Object deleteUserByfirstName(String firstName);
}
