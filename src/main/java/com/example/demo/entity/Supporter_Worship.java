package com.example.demo.entity;

import java.time.LocalDateTime;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;

@Entity
public class Supporter_Worship {

	@Column(name = "supporter_name")
	private String supporterName;
	
	@Column(name = "worship_type")
	private String worshipType;
	
	@Column(name = "schedule")
	private LocalDateTime schedule;
	
	@Column(name = "remark")
	private String remark;

	public String getSupporterName() {
		return supporterName;
	}

	public void setSupporterName(String supporterName) {
		this.supporterName = supporterName;
	}

	public String getWorshipType() {
		return worshipType;
	}

	public void setWorshipType(String worshipType) {
		this.worshipType = worshipType;
	}

	public LocalDateTime getSchedule() {
		return schedule;
	}

	public void setSchedule(LocalDateTime schedule) {
		this.schedule = schedule;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
