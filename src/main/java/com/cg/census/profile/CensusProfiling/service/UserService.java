package com.cg.census.profile.CensusProfiling.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.census.profile.CensusProfiling.exception.DuplicateRecordException;
import com.cg.census.profile.CensusProfiling.exception.RecordNotFoundException;
import com.cg.census.profile.CensusProfiling.model.User;
import com.cg.census.profile.CensusProfiling.model.UserFamilyMember;
import com.cg.census.profile.CensusProfiling.repository.UserFamilyMemberRepository;
import com.cg.census.profile.CensusProfiling.repository.UserRepository;

@Service
public class UserService {
	public static final Logger LOG = LoggerFactory.getLogger(UserFamilyMember.class);
	@Autowired
	private UserRepository repository;

	public User userRegister(User user) {
		User optionalUser = repository.findUserByEmail(user.getEmail());
		if (optionalUser == null) {
			return repository.save(user);
		} else {
			throw new DuplicateRecordException("User Already exists");
		}
	}

//

	@Autowired
	private UserFamilyMemberRepository memRepository;

	public UserFamilyMember addMember(UserFamilyMember member) {
		// UserFamilyMember famMem = memRepository.
		return memRepository.save(member);
	}

	@Transactional
	public void deleteMember(String name) {
		List<UserFamilyMember> famMem = memRepository.findBymemFirstName(name);
		if (famMem == null) {
			throw new RecordNotFoundException("Record with given first name Not Found");
		} else {
			memRepository.deleteBymemFirstName(name);
		}
	}

	public void deleteMemberById(int mem_id) {
		UserFamilyMember famMem = memRepository.getById(mem_id);
		if (famMem == null) {
			throw new RecordNotFoundException("Record with given ID Not Found");
		} else {
			memRepository.deleteById(mem_id);
		}

	}

	public List<UserFamilyMember> findMemberByFirstName(String firstName) {

		List<UserFamilyMember> famMem = memRepository.findBymemFirstName(firstName);
		if (famMem.isEmpty()) {
			throw new RecordNotFoundException("Record with given Name Not Found");
		} else {
			return famMem;
		}
	}

	public List<UserFamilyMember> findMemberByLastName(String lastName) {

		List<UserFamilyMember> famMem = memRepository.findBymemLastName(lastName);
		if (famMem.isEmpty()) {
			throw new RecordNotFoundException("Record with given Last Name Not Found");
		} else {
			return famMem;
		}

	}

	public List<UserFamilyMember> findMemberById(int mId) {

		List<UserFamilyMember> famMem = memRepository.findBymemId(mId);
		if (famMem.isEmpty()) {
			throw new RecordNotFoundException("Record with given Last Name Not Found");
		} else {
			return famMem;
		}
	}

	public List<UserFamilyMember> findByRelation(String relation) {
		List<UserFamilyMember> famMem = memRepository.findByrelationWithMember(relation);
		if (famMem.isEmpty()) {
			throw new RecordNotFoundException("Record with given Last Name Not Found");
		} else {
			return famMem;
		}
	}

	public List<UserFamilyMember> findByAge(int age) {
		List<UserFamilyMember> famMem = memRepository.findByageOfMember(age);
		if (famMem.isEmpty()) {
			throw new RecordNotFoundException("Record with given Last Name Not Found");
		} else {
			return famMem;
		}

	}

	public UserFamilyMember updateMemberInfo(UserFamilyMember member) {
	
		return memRepository.save(member);
	}
	
	public List<UserFamilyMember> findFamilyMembers(int user_uid) {
		List<UserFamilyMember> famMem = memRepository.findByUser_uid(user_uid);
		if(famMem.isEmpty()) {
			throw new RecordNotFoundException("No Record found");
		} else {
			return famMem;
		}
	}

	// Updating info
	public User updateUserProfile(User user) {
	
		if (user == null) {
			throw new RecordNotFoundException("Record to be updated Not Found");
		} 
		else {
			
			return repository.save(user);
		}
	}

}
