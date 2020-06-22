package com.example.demo.entity;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

@Entity
@Table(name = "temple")
public class Temple {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "temple_id")
	private String templeId;

	@Column(name = "password")
	private String password;

	@Column(name = "temple_name")
	private String templeName;

	@Column(name = "denomination")
	private String denomination;

	@Column(name = "monk_name")
	private String monkName;

	@Column(name = "position")
	private String position;

	@Column(name = "postalcode")
	private String postalcode;

	@Column(name = "address")
	private String address;

	@Column(name = "email")
	private String email;
	
	@Column(name = "role")
	private String role;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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

	public String getDenomination() {
		return denomination;
	}

	public void setDenomination(String denomination) {
		this.denomination = denomination;
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
