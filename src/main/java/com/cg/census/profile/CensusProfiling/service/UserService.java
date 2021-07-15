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
public class UserService {
	public static final Logger LOG  = LoggerFactory.getLogger(UserFamilyMember.class);
	@Autowired
	private UserRepository repository ;
	
	
	public User userRegister(User user) {
	return repository.save(user);
	}
	
//
	
	@Autowired
	private UserFamilyMemberRepository memRepository;

	public UserFamilyMember addMember(UserFamilyMember member) {
		return memRepository.save(member);
	}

	@Transactional
	public void deleteMember(String name) {
		memRepository.deleteBymemFirstName(name);
	}

	public void deleteMemberById(int mem_id) {
		memRepository.deleteById(mem_id);
	}

	public List<UserFamilyMember> findMemberByFirstName(String firstName) {
		return memRepository.findBymemFirstName(firstName);
	}

	public List<UserFamilyMember> findMemberByLastName(String lastName) {
		return memRepository.findBymemLastName(lastName);
	}

	public List<UserFamilyMember> findMemberById(int mId) {
		return memRepository.findBymemId(mId);
	}

	public List<UserFamilyMember> findByRelation(String relation) {
		return memRepository.findByrelationWithMember(relation);
	}

	public List<UserFamilyMember> findByAge(int age) {
		return memRepository.findByageOfMember(age);
	}

	public UserFamilyMember updateMemberInfo(int id ,UserFamilyMember member) {
		UserFamilyMember fMem = memRepository.getById(id);
		fMem = member;
		return memRepository.save(fMem);
	}

	//Updating info



}
