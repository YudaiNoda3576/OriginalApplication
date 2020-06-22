package com.example.demo.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

public class TempleForm {
	private Integer id;
	
	@NotBlank(groups = ValidGroup1.class)
	private String templeId;
	
	@NotBlank(groups = ValidGroup1.class)
	@Length(min = 8, max = 32, groups = ValidGroup2.class)
	@Pattern(regexp = "^[a-zA-Z0-9]+$", groups = ValidGroup3.class)
	private String password;
	
	@NotBlank(groups = ValidGroup1.class)
	private String templeName;
	
	@NotBlank(groups = ValidGroup1.class)
	private String denomination;
	
	@NotBlank(groups = ValidGroup1.class)
	private String monkName;
	
	@NotBlank(groups = ValidGroup1.class)
	private String position;
	
	@NotBlank(groups = ValidGroup1.class)
	private String postalcode;
	
	@NotBlank(groups = ValidGroup1.class)
	private String address;
	
	@Email(groups = ValidGroup1.class)
	private String email;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDenomination() {
		return denomination;
	}
	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}
	
	public String getTempleId() {
		return templeId;
	}
	public void setTempleId(String templeId) {
		this.templeId = templeId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTempleName() {
		return templeName;
	}
	public void setTempleName(String templeName) {
		this.templeName = templeName;
	}

	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getPostalcode() {
		return postalcode;
	}
	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}
	
	public String getMonkName() {
		return monkName;
	}
	public void setMonkName(String monkName) {
		this.monkName = monkName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
