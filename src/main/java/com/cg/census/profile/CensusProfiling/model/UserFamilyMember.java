package com.cg.census.profile.CensusProfiling.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
//import java.util.*;

@Entity
@Table(name = "FamilyMembers")
public class UserFamilyMember {
	@Id
	private int memId;

	@Column
	private String memFirstName;

	@Column
	private String memLastName;

	@Column
	private String memGender;

	@Column
	private String relation;

	@Column
	private String dob;

	@JsonBackReference
	@ManyToOne
	private User user;

	public UserFamilyMember() {
		super();
	}

	public UserFamilyMember(int memId, String memFirstName, String memLastName, String memGender, String relation,
			String dob, User user) {
		super();
		this.memId = memId;
		this.memFirstName = memFirstName;
		this.memLastName = memLastName;
		this.memGender = memGender;
		this.relation = relation;
		this.dob = dob;
		this.user = user;
	}

	public int getMemId() {
		return memId;
	}

	public void setMemId(int memId) {
		this.memId = memId;
	}

	public String getMemFirstName() {
		return memFirstName;
	}

	public void setMemFirstName(String memFirstName) {
		this.memFirstName = memFirstName;
	}

	public String getMemLastName() {
		return memLastName;
	}

	public void setMemLastName(String memLastName) {
		this.memLastName = memLastName;
	}

	public String getMemGender() {
		return memGender;
	}

	public void setMemGender(String memGender) {
		this.memGender = memGender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

}
