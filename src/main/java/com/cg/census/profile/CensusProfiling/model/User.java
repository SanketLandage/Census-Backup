package com.cg.census.profile.CensusProfiling.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Users")
public class User {
	@Id
	private int uid;
	@Column
	private String firstName;

	@Column
	private String lastName;

	@Column
	private String gender;

	@Column
	private String email;

	@Column
	private String password;

	@Column
	private int numOfKids;
	@JsonManagedReference
	@OneToMany(mappedBy = "user" , cascade = CascadeType.ALL)
	private List<UserFamilyMember> usermMem = new ArrayList<>();

	public User() {
		super();
	}

	public User(int uid) {
		super();
		this.uid = uid;
	}

//	public User(int uid, String firstName, String lastName) {
//		super();
//		this.uid = uid;
//		this.firstName = firstName;
//		this.lastName = lastName;
//	}

	public int getUid() {
		return uid;
	}

	public User(int uid, String firstName, String lastName, String gender, String email, String password, int numOfKids,
			List<UserFamilyMember> usermMem) {
		super();
		this.uid = uid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.email = email;
		this.password = password;
		this.numOfKids = numOfKids;
		this.usermMem = usermMem;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<UserFamilyMember> getUsermMem() {
		return usermMem;
	}

	public void setUsermMem(List<UserFamilyMember> usermMem) {
		this.usermMem = usermMem;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getNumOfKids() {
		return numOfKids;
	}

	public void setNumOfKids(int numOfKids) {
		this.numOfKids = numOfKids;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
