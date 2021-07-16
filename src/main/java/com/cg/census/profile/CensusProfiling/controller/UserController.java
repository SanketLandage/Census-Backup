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

import com.cg.census.profile.CensusProfiling.exception.NoAccessException;
import com.cg.census.profile.CensusProfiling.model.User;
import com.cg.census.profile.CensusProfiling.model.UserFamilyMember;
import com.cg.census.profile.CensusProfiling.secure.service.AppUserService;
import com.cg.census.profile.CensusProfiling.service.UserService;

@RestController
public class UserController {
	
	public static final Logger LOG = LoggerFactory.getLogger(User.class);
	
	@Autowired
	private UserService service ;
	
	
	@Autowired
	AppUserService appUserService;
	
	////User Registration
	
	@PostMapping("/registerUser")
	public User userRegister(@RequestBody User user) {
		LOG.info("User Register");
			return service.userRegister(user);
	}
	
//	@Autowired
//	private UserFamilyMemberService service;

	////Add New Family Member
	@PostMapping("/addmember")
	public UserFamilyMember regMember(@RequestBody UserFamilyMember user) {
		LOG.info("Member add");
		if (appUserService.loginStatus().getRole().toString().equals("USER")) {
			return service.addMember(user);
		}
		else {
			throw new NoAccessException("You dont have access");
		}
	}
	
	////Delete Family Member by Name
	@DeleteMapping("/deleteMemberByFirstName/{name}")
	public void deleteMember(@PathVariable(value = "name") String name) {
		LOG.info("Delete Family Member by First name");
		if (appUserService.loginStatus().getRole().toString().equals("USER")) {
			service.deleteMember(name);
		}else {
			throw new NoAccessException("You dont have access");
		}
	}

	////Delete Family Member BY ID
	@DeleteMapping("/deleteMemberById/{mem_id}")
	public void deleteMember(@PathVariable("mem_id") int mem_id) {
		LOG.info("Delete Member Using ID");
		if (appUserService.loginStatus().getRole().toString().equals("USER")) {
			service.deleteMemberById(mem_id);
		}else {
			throw new NoAccessException("You dont have access");
		}
		
	}
	
	
	////Get Member by First Name
	@GetMapping("/getMemberByFirstName/{fname}")
	public List<UserFamilyMember> getMemberBYFirstName(@PathVariable(value = "fname") String fname) {
		LOG.info("Get Member by First Name");
		if (appUserService.loginStatus().getRole().toString().equals("USER")) {
			return service.findMemberByFirstName(fname);
		}
		else {
			throw new NoAccessException("You dont have access");
		}
	}
	
//	////Get Member by Last Name
//	@GetMapping("/getMemberByLastName/{lname}")
//	public List<UserFamilyMember> getMemberByLastName(@PathVariable(value = "lname") String lname) {
//		LOG.info("Get Member by Last Name");
//		return service.findMemberByLastName(lname);
//	}
	
	///Get Member by Id
	@GetMapping("/getMemberById/{mid}")
	public List<UserFamilyMember> getMemberById(@PathVariable(value = "mid") int mid) {
		LOG.info("Getting Family Member by ID");
		if (appUserService.loginStatus().getRole().toString().equals("USER")) {
		return service.findMemberById(mid);
		}
		else {
			throw new NoAccessException("You dont have access");
		}
	}

	////Get Member By Relation
	@GetMapping("/getMemberByRelation/{relation}")
	public List<UserFamilyMember> getMemberByRelation(@PathVariable(value = "relation") String relation) {
		LOG.info("Getting Family Members By Relation");
		if (appUserService.loginStatus().getRole().toString().equals("USER")) {
		return service.findByRelation(relation);
		}
		else {
			throw new NoAccessException("You dont have access");
		}
	}
	
	///Get Family Members using Date of birth
	@GetMapping("/getAllMembersByAge/{age}")
	public List<UserFamilyMember> getMemberByAge(@PathVariable(value = "age") int age) {
		LOG.info("Getting Family Members By Relation");
		if (appUserService.loginStatus().getRole().toString().equals("ADMIN")) {
			return service.findByAge(age);
		}
		else {
			throw new NoAccessException("You dont have access");
		}
	}
	
	
	@PutMapping("/updateUserInfo/{id}")
	public User updateUserProfile(@PathVariable("id") int id , @RequestBody User user) {
		LOG.info("Update User Info");
		if (appUserService.loginStatus().getRole().toString().equals("USER")) { 
		return service.updateUserProfile(id, user);
		}
		else {
			throw new NoAccessException("You dont have access");
		}
	}
	
	//// Update User's Family Member
	@PutMapping("/updateFamilyMemInfo/{id}")
	public UserFamilyMember updateMemId(@PathVariable("id") int id , @RequestBody UserFamilyMember memId) {
		LOG.info("update memId");
		if (appUserService.loginStatus().getRole().toString().equals("USER")) {
		return service.updateMemberInfo(id, memId);
		}
		else {
			throw new NoAccessException("You dont have access");
		}
	}

}
