package com.example.demo.entity;

import java.time.LocalDateTime;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

@Entity
@Table(name = "worship")
public class Worship {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "worship_id")
	private Integer worshipId;
	
	@Column(name = "worship_type")
	private String worshipType;
	
	@Column(name = "schedule")
	private LocalDateTime schedule;

	@Column(name = "supporter_id")
	private Integer supporterId;

	public Integer getWorshipId() {
		return worshipId;
	}

	public void setWorshipId(Integer worshipId) {
		this.worshipId = worshipId;
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

	public Integer getSupporterId() {
		return supporterId;
	}

	public void setSupporterId(Integer supporterId) {
		this.supporterId = supporterId;
	}
	
	
	
}
