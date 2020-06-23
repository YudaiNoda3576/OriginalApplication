package com.example.demo.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class SupporterForm {

	private Integer supporterId;
	@NotBlank(groups = ValidGroup1.class)
	private String supporterName;
	@NotBlank(groups = ValidGroup1.class)
	private String ownerName;
	@NotBlank(groups = ValidGroup1.class)
	@Pattern(regexp = "^\\d{3}\\-?\\d{4}$", groups = ValidGroup2.class)
	private String postalcode;
	@NotBlank(groups = ValidGroup1.class)
	private String address;
	@NotBlank(groups = ValidGroup1.class)
	private String phoneNumber;
	@Email
	private String email;

	public Integer getSupporterId() {
		return supporterId;
	}

	public void setSupporterId(Integer supporterId) {
		this.supporterId = supporterId;
	}

	public String getSupporterName() {
		return supporterName;
	}

	public void setSupporterName(String supporterName) {
		this.supporterName = supporterName;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}