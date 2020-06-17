package com.example.demo.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class SupporterForm {

	private Integer supporter_id;
	@NotBlank
	private String supporter_name;
	@NotBlank
	private String owner_name;
	@NotBlank
	private String postalcode;
	@NotBlank
	private String adress;
	
	private String phoneNumber;
	@Email
	private String email;

	public Integer getSupporter_id() {
		return supporter_id;
	}

	public void setSupporter_id(Integer supporter_id) {
		this.supporter_id = supporter_id;
	}

	public String getSupporter_name() {
		return supporter_name;
	}

	public void setSupporter_name(String supporter_name) {
		this.supporter_name = supporter_name;
	}

	public String getOwner_name() {
		return owner_name;
	}

	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
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
	
	
	
}
