package com.cg.census.profile.CensusProfiling.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.census.profile.CensusProfiling.model.User;
import com.cg.census.profile.CensusProfiling.model.UserFamilyMember;
import com.cg.census.profile.CensusProfiling.repository.UserFamilyMemberRepository;
import com.cg.census.profile.CensusProfiling.repository.UserRepository;

@Service
public class AdminService {
	public static final Logger LOG  = LoggerFactory.getLogger(UserFamilyMember.class);
	@Autowired
	private UserRepository repository ;
	
	public User userRegister(User user) {
		return repository.save(user);
		}
	
	public List<User> findUserByFirstName(String firstName){
		LOG.info("findUserByFirstName");
		return repository.findUserByFirstName(firstName);
		
	}
	
	public List<User> findUserByLastName(String lastName){
		LOG.info("findUserByLastName");
		return repository.findUserByLastName(lastName);
		
	}
	
	public List<User> findUserByGender(String gender){
		LOG.info("findUserByGender");
		return repository.findUserByGender(gender);
		
	}
	
	public List<User> findUserByEmail(String email){
		LOG.info("findUserByEmail");
		return repository.findUserByEmail(email);
	}

	public List<User> findAllUsers() {
		return repository.findAll();
	}
	
	public void deleteUserById(int id){
	  repository.deleteAllByuid(id);
	}
	
	public void deleteUserByfirstName(String name){
		  repository.deleteUserByfirstName(name);
	}
	public User updateMemberInfo(int id ,User user) {
		User fMem = repository.getById(id);
		fMem = user;
		return repository.save(fMem);
	}
}
