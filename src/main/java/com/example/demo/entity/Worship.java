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
	
//	Enum 値を変換　Domaの機能　樋口さんの参考
	@Column(name = "worship_type")
	private String worshipType;
	
	@Column(name = "schedule")
	private LocalDateTime schedule;
	
	@Column(name = "remark")
	private String remark;

	@Column(name = "supporter_id")
	private Integer supporterId;


	public String getRemark() {
		return remark;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}
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
