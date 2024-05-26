package com.validate.validations_Exceptionss.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="validations")


public class User {
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public User(long id, @NotNull(message = "UserName should not be null") String name,
			@Email(message = "invalid email address") String email, long mobile, String gender,
			@Min(18) @Max(60) int age, @NotNull String nationality) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.gender = gender;
		this.age = age;
		this.nationality = nationality;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	@Column(name="userId")
	private long id;
	
	@Column(name="uName")
	@NotNull(message = "UserName should not be null")
	private String name;
	
	@Column(name="email")
	@Email(message = "invalid email address")
	private String email;
	
	@Column(name="mobile")
	private long mobile;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="age")
	@Min(18)
	@Max(60)
	private int age;
	
	@Column(name="nationality")
	@NotNull
	private String nationality;

}
