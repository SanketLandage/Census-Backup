package com.cg.census.profile.CensusProfiling.controller;

import java.util.List;

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
import com.cg.census.profile.CensusProfiling.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@RestController
public class UserController {
	
	public static final Logger LOG = LoggerFactory.getLogger(User.class);
	
	@Autowired
	private UserService service ;
	
	////User Registration
	//@ApiOperation(value = "User registration" , authorizations = { @Authorization(value = "jwtToken")})
	@PostMapping("/register")
	public User userRegister(@RequestBody User user) {
		LOG.info("addUser");
		return service.userRegister(user);
	}
	
//	@Autowired
//	private UserFamilyMemberService service;

	////Add New Family Member
	@ApiOperation(value = "Add new Family Member" , authorizations = { @Authorization(value = "jwtToken")})
	@PostMapping("/addmember")
	public UserFamilyMember regMember(@RequestBody UserFamilyMember user) {
		LOG.info("Member add");
		return service.addMember(user);
	}
	
	////Delete Family Member by Name
	@ApiOperation(value = "Delete Family Member using First Name" , authorizations = { @Authorization(value = "jwtToken")})
	@DeleteMapping("/deleteMemberByFirstName/{name}")
	public void deleteMember(@PathVariable(value = "name") String name) {
		service.deleteMember(name);
	}

	////Delete Family Member BY ID
	@ApiOperation(value = "Delete Family Member using Member_ID" , authorizations = { @Authorization(value = "jwtToken")})
	@DeleteMapping("/deleteMemberById/{mem_id}")
	public void deleteMember(@PathVariable("mem_id") int mem_id) {
		LOG.info("DeleteMember");
		service.deleteMemberById(mem_id);
		// This is delete
	}
	
	
	////Get Member by First Name
	@ApiOperation(value = "Search Family Member using First Name filter" , authorizations = { @Authorization(value = "jwtToken")})
	@GetMapping("/getMemberByFirstName/{fname}")
	public List<UserFamilyMember> getMemberBYFirstName(@PathVariable(value = "fname") String fname) {
		LOG.info("Get Member by FIrst Name");
		return service.findMemberByFirstName(fname);
	}
	
//	////Get Member by Last Name
//	@GetMapping("/getMemberByLastName/{lname}")
//	public List<UserFamilyMember> getMemberByLastName(@PathVariable(value = "lname") String lname) {
//		LOG.info("Get Member by Last Name");
//		return service.findMemberByLastName(lname);
//	}
	
	///Get Member by Id
	@ApiOperation(value = "Search Family Member using Id filter" , authorizations = { @Authorization(value = "jwtToken")})
	@GetMapping("/getMemberById/{mid}")
	public List<UserFamilyMember> getMemberById(@PathVariable(value = "mid") int mid) {
		LOG.info("Getting Family Member by ID");
		return service.findMemberById(mid);
	}

	////Get Member By Relation
	@ApiOperation(value = "Search Family Member Using relation filter" , authorizations = { @Authorization(value = "jwtToken")})
	@GetMapping("/getMemberByRelation/{relation}")
	public List<UserFamilyMember> getMemberByRelation(@PathVariable(value = "relation") String relation) {
		LOG.info("Getting Family Members By Relation");
		return service.findByRelation(relation);
	}
	
	///Get Family Members using Date of birth
	@ApiOperation(value = "Search Family Memeber using Age filter" , authorizations = { @Authorization(value = "jwtToken")})
	@GetMapping("/getMembersByAge/{age}")
	public List<UserFamilyMember> getMemberByDob(@PathVariable(value = "dob") int age) {
		LOG.info("Getting Family Members By Relation");
		return service.findByAge(age);
	}
	
	
	@ApiOperation(value = "Update Users information" , authorizations = { @Authorization(value = "jwtToken")})
	@PutMapping("/updateUserInfo/{id}")
	public User updateUserProfile(@PathVariable("id") int id , @RequestBody User user) {
		LOG.info("Update User Info");
		return service.updateUserProfile(id, user);
	}
	
	//// Update User's Family Member
	@PutMapping("/updateFamilyMemInfo/{id}")
	@ApiOperation(value = "Update information of Family Member" , authorizations = { @Authorization(value = "jwtToken")})
	public UserFamilyMember updateMemId(@PathVariable("id") int id , @RequestBody UserFamilyMember memId) {
		LOG.info("update memId");
		return service.updateMemberInfo(id, memId);
	}

}
