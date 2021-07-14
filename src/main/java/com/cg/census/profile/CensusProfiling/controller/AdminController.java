package com.cg.census.profile.CensusProfiling.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.census.profile.CensusProfiling.model.User;
import com.cg.census.profile.CensusProfiling.model.UserFamilyMember;
import com.cg.census.profile.CensusProfiling.service.AdminService;


@RestController
public class AdminController {
	
public static final Logger LOG = LoggerFactory.getLogger(User.class);
	
	@Autowired
	private AdminService service ;
	
	///Admin can add Users
	@PostMapping("/addUser")
	public User userRegister(@RequestBody User user) {
		LOG.info("addUser");
		return service.userRegister(user);
	}
	
	////Get All Users
	@GetMapping("/getAllUsers")
	public List<User> getAllUsers() {
		LOG.info("AllUsers");
		return service.findAllUsers();
	}
	
	
	///////Get Users by First Name
	@GetMapping("/getbyfirstname/{firstName}")
	public List<User> getByFirstName(@PathVariable("firstName") String firstName) {
		LOG.info("getByFirstName");
		return service.findUserByFirstName(firstName);
	}

	////Get Users by Last Name
	@GetMapping("/getbylastname/{lastName}")
	public List<User> getByLastName(@PathVariable("lastName") String lastName) {
		LOG.info("getBylastName");
		return service.findUserByFirstName(lastName);
	}

	
	//Get user by Email
	
	@GetMapping("/getbyemail/{email}")
	public List<User> getByEmail(@PathVariable("email") String email) {
		LOG.info("getByEmail");
		return service.findUserByEmail(email);
	}

	///Admin can get All users by their Gender
	@GetMapping("/getbyeGender/{gender}")
	public List<User> getByGender(@PathVariable("gender") String gender) {
		LOG.info("getByEmail");
		return service.findUserByGender(gender);

	}
	
	////Admin Can Delete User by ID
	
	@Transactional
	@DeleteMapping("/deleteUserById/{id}")
	public void deleteUserById(@PathVariable("id") int id) {
		service.deleteUserById(id);
	}
	
	@Transactional
	@DeleteMapping("/deleteUserByFirstName/{name}")
	public void deleteUserById(@PathVariable("name") String name) {
		service.deleteUserByfirstName(name);
	}
	
	@PutMapping("/updateUserInfo/{id}")
	public User updateMemId(@PathVariable("id") int id , @RequestBody User user) {
		LOG.info("Update User Info");
		return service.updateMemberInfo(id, user);
	}
}
