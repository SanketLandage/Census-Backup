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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;


@RestController

public class AdminController {
	
public static final Logger LOG = LoggerFactory.getLogger(User.class);
	
	@Autowired
	private AdminService service ;
	
	///Admin can add Users
	@ApiOperation(value = "Add New user" , authorizations = { @Authorization(value = "jwtToken")})
	@PostMapping("/addUser")
	public User userRegister(@RequestBody User user) {
		LOG.info("addUser");
		return service.userRegister(user);
	}
	
	////Get All Users
	@ApiOperation(value = "Get All Users" , authorizations = { @Authorization(value = "jwtToken")})
	@GetMapping("/getAllUsers")
	public List<User> getAllUsers() {
		LOG.info("AllUsers");
		return service.findAllUsers();
	}
	
	
	///////Get Users by First Name
	@ApiOperation(value = "Get Users by First Name" , authorizations = { @Authorization(value = "jwtToken")})
	@GetMapping("/getbyfirstname/{firstName}")
	public List<User> getByFirstName(@PathVariable("firstName") String firstName) {
		LOG.info("getByFirstName");
		return service.findUserByFirstName(firstName);
	}
	
	/////Get Users by User ID
	@ApiOperation(value = "Get Users by ID" , authorizations = { @Authorization(value = "jwtToken")})
	@GetMapping("/getUserById/{id}")
	public User getUserById(@PathVariable("id") int id) {
		LOG.info("getByFirstName");
		return service.getUserById(id);
	}
	////Get Users by Last Name
	@ApiOperation(value = "Get Users by Last Name" , authorizations = { @Authorization(value = "jwtToken")})
	@GetMapping("/getbylastname/{lastName}")
	public List<User> getByLastName(@PathVariable("lastName") String lastName) {
		LOG.info("getBylastName");
		return service.findUserByFirstName(lastName);
	}

	
	//Get user by Email
	@ApiOperation(value = "Get Users by Email" , authorizations = { @Authorization(value = "jwtToken")})
	@GetMapping("/getbyemail/{email}")
	public List<User> getByEmail(@PathVariable("email") String email) {
		LOG.info("getByEmail");
		return service.findUserByEmail(email);
	}

	///Admin can get All users by their Gender
	@ApiOperation(value = "Get Users by Gender" , authorizations = { @Authorization(value = "jwtToken")})
	@GetMapping("/getbyeGender/{gender}")
	public List<User> getByGender(@PathVariable("gender") String gender) {
		LOG.info("getByEmail");
		return service.findUserByGender(gender);

	}
	
	////Admin Can Delete User by ID
	
	@Transactional
	@ApiOperation(value = "Delete User by ID" , authorizations = { @Authorization(value = "jwtToken")})
	@DeleteMapping("/deleteUserById/{id}")
	public void deleteUserById(@PathVariable("id") int id) {
		service.deleteUserById(id);
	}
	
	@Transactional
	@ApiOperation(value = "Delete User by First Name" , authorizations = { @Authorization(value = "jwtToken")})
	@DeleteMapping("/deleteUserByFirstName/{name}")
	public void deleteUserById(@PathVariable("name") String name) {
		service.deleteUserByfirstName(name);
	}
	
	@ApiOperation(value = "Update User" , authorizations = { @Authorization(value = "jwtToken")})
	@PutMapping("/updateUserInfo/{id}")
	public User updateMemId(@PathVariable("id") int id , @RequestBody User user) {
		LOG.info("Update User Info");
		return service.updateMemberInfo(id, user);
	}
}
