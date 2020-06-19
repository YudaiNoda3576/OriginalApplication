package com.example.demo.entity;



import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

@Entity
@Table(name = "supporter")
public class Supporter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "supporter_id")
	private Integer supporterId;
	
	@Column(name = "supporter_name")
	private String supporterName;
	
	@Column(name = "owner_name")
	private String ownerName;
	
	@Column(name = "postalcode")
	private String postalcode;
	
	@Column(name = "adress")
	private String adress;
	
	@Column(name = "phoneNumber")
	private String phoneNumber;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "temple_id")
	private Integer templeId;

	

	public Integer getTempleId() {
		return templeId;
	}

	public void setTempleId(Integer templeId) {
		this.templeId = templeId;
	}

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
