package com.example.demo.entity;

import java.time.LocalDateTime;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;

import com.example.demo.domain.WorshipOpts;

@Entity
public class SupporterWorship {
	
	@Column(name = "supporter_name")
	private String supporterName;
	
	@Column(name = "worship_opts")
	private WorshipOpts worshipOpts;
	
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
	

	public WorshipOpts getWorshipOpts() {
		return worshipOpts;
	}

	public void setWorshipOpts(WorshipOpts worshipOpts) {
		this.worshipOpts = worshipOpts;
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
