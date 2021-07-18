package com.cg.census.profile.CensusProfiling.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.census.profile.CensusProfiling.exception.DuplicateRecordException;
import com.cg.census.profile.CensusProfiling.exception.RecordNotFoundException;
import com.cg.census.profile.CensusProfiling.model.User;
import com.cg.census.profile.CensusProfiling.model.UserFamilyMember;
import com.cg.census.profile.CensusProfiling.repository.UserFamilyMemberRepository;
import com.cg.census.profile.CensusProfiling.repository.UserRepository;

@Service
public class AdminService {
	public static final Logger LOG = LoggerFactory.getLogger(UserFamilyMember.class);
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private UserFamilyMemberRepository repo;

	public User userRegister(User user) {
		User optionalUser = repository.findUserByEmail(user.getEmail());
		if (optionalUser == null) {
			return repository.save(user);
		} else {
			throw new DuplicateRecordException("User Already exists");
		}
	}

	public List<User> findUserByFirstName(String firstName) {
		LOG.info("findUserByFirstName");

		List<User> user = repository.findUserByFirstName(firstName);
		if (user.isEmpty()) {
			throw new RecordNotFoundException("Record with given first name Not Found");
		} else {
			return user;
		}

	}

	public List<User> findUserByLastName(String lastName) {

		LOG.info("findUserByLastName");
		List<User> user = repository.findUserByLastName(lastName);
		if (user.isEmpty()) {
			throw new RecordNotFoundException("Record Not Found of given last name");
		} else {
			return user;
		}

	}

	public List<User> findUserByGender(String gender) {
		LOG.info("findUserByGender");
		List<User> user = repository.findUserByGender(gender);
		if (user.isEmpty()) {
			throw new RecordNotFoundException("Record does not exists of given gender type");
		} else {
			return user;
		}

	}

	public List<User> findTargetedUsers(){
		List<User> user = repository.findTargetUsers();
		if(user.isEmpty()) {
			throw new RecordNotFoundException("No User avialable");	
		}
		else {
			return user;
		}
	}
	
	public List<UserFamilyMember> findTargetedMembers(){
		List<UserFamilyMember> user = repo.findTargetMembers();
		if(user.isEmpty()) {
			throw new RecordNotFoundException("No User avialable");	
		}
		else {
			return user;
		}
	}
	
	public User findUserByEmail(String email) {
		LOG.info("findUserByEmail");
		User user = repository.findUserByEmail(email);
		if(user == null ) {
			throw new RecordNotFoundException("User With given Email does not Exists!");
		}
		else {
			return user;
		}
	}

	public List<User> findAllUsers() {
		List<User> user = repository.findAll();
		if(user.isEmpty()) {
			throw new RecordNotFoundException("No user exists in Database");
		}
		else {
			return user;
		}
	}
	
	public List<UserFamilyMember> getAllFamilyMembers(){
		List<UserFamilyMember> members = repo.findAll();
		if(members.isEmpty()) {
			throw new RecordNotFoundException("No user exists in Database");
		}
		else {
			return members;
		}
	}
	

	public void deleteUserById(int id) {
		User user =repository.findByuid(id);
		if(user == null) {
			throw new RecordNotFoundException("User you are trying to delete does not exists");
		}
		else{
			repository.deleteAllByuid(id);
		}
	}

	public void deleteUserByEmail(String email) {
		User user =repository.findUserByEmail(email);
		if(user == null) {
			throw new RecordNotFoundException("User you are trying to delete does not exists");
		}
		else{
			repository.deleteUserByemail(email);
		}
	}

	public User updateMemberInfo(int id, User user) {
		User fMem = repository.getById(id);
		fMem = user;
		return repository.save(fMem);
	}

	public User getUserById(int id) {
		User user = repository.findByuid(id);
		if(user == null) {
			throw new RecordNotFoundException("User Does not Exists");
		}
		else {
			return user;
		}
	}
	
	public List<User> getUsersByCity(String city){
		List<User> user = repository.findUserBycity(city);
		if(user.isEmpty()) {
			throw new RecordNotFoundException("NO User avialable from given city");	
		}
		else {
			return user;
		}
	}
	
	public List<User> getUsersByAge(int age){
		List<User> user = repository.findUserByage(age);
		if(user.isEmpty()) {
			throw new RecordNotFoundException("NO User avialable of given Age");	
		}
		else {
			return user;
		}
	}
}
