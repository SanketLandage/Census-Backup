package com.cg.census.profile.CensusProfiling.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//import com.cg.census.profile.CensusProfiling.model.User;
import com.cg.census.profile.CensusProfiling.model.UserFamilyMember;
import com.cg.census.profile.CensusProfiling.service.UserFamilyMemberService;

@RestController
public class UserFamilyMemberController {
//	public static final Logger LOG = LoggerFactory.getLogger(UserFamilyMember.class);
//
//	@Autowired
//	private UserFamilyMemberService service;
//
//	@PostMapping("/addmember")
//	public UserFamilyMember regMember(@RequestBody UserFamilyMember user) {
//		LOG.info("Member add");
//		return service.addMember(user);
//	}
//
//	@DeleteMapping("/deleteMemberByName/{name}")
//	public void deleteMember(@PathVariable(value = "name") String name) {
//		service.deleteMember(name);
//	}
//
//	@DeleteMapping("/deleteMemberById/{mem_id}")
//	public void deleteMember(@PathVariable("mem_id") int mem_id) {
//		LOG.info("DeleteMember");
//		service.deleteMemberById(mem_id);
//		// This is delete
//	}
//
//	@GetMapping("/getMemberByFirstName/{fname}")
//	public List<UserFamilyMember> getMemberBYFirstName(@PathVariable(value = "fname") String fname) {
//		LOG.info("Get Member by FIrst Name");
//		return service.findMemberByFirstName(fname);
//	}
//
//	@GetMapping("/getMemberByLastName/{lname}")
//	public List<UserFamilyMember> getMemberByLastName(@PathVariable(value = "lname") String lname) {
//		LOG.info("Get Member by Last Name");
//		return service.findMemberByLastName(lname);
//	}
//
//	@GetMapping("/getMemberById/{mid}")
//	public List<UserFamilyMember> getMemberById(@PathVariable(value = "mid") int mid) {
//		LOG.info("Getting Family Member by ID");
//		return service.findMemberById(mid);
//	}
//
//	@GetMapping("/getMemberByRelation/{relation}")
//	public List<UserFamilyMember> getMemberByRelation(@PathVariable(value = "relation") String relation) {
//		LOG.info("Getting Family Members By Relation");
//		return service.findByRelation(relation);
//	}
//
//	@GetMapping("/getMemberByDob/{dob}")
//	public List<UserFamilyMember> getMemberByDob(@PathVariable(value = "dob") String dob) {
//		LOG.info("Getting Family Members By Relation");
//		return service.findByDob(dob);
//	}

}
