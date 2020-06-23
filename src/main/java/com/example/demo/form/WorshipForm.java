package com.example.demo.form;

import java.time.LocalDateTime;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import com.example.demo.domain.WorshipOpts;

public class WorshipForm {

	private Integer worshipId;

	private Integer worshipType;

	@NotNull(groups = ValidGroup1.class)
	@Future(groups = ValidGroup2.class)
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime schedule;

	@Length(min = 0, max = 500, groups = ValidGroup1.class)
	private String remark;

	private Integer supporterId;

//	@NotBlank(groups = ValidGroup1.class)
	private WorshipOpts worshipOpts;

	public WorshipOpts[] getWorshipOpts() {
		return WorshipOpts.values();
	}

	public void setWorshipOpts(WorshipOpts worshipOpts) {
		this.worshipOpts = worshipOpts;
	}

	public Integer getSupporterId() {
		return supporterId;
	}

	public void setSupporterId(Integer supporterId) {
		this.supporterId = supporterId;
	}

	public Integer getWorshipId() {
		return worshipId;
	}

	public void setWorshipId(Integer worshipId) {
		this.worshipId = worshipId;
	}


	public Integer getWorshipType() {
		return worshipType;
	}

	public void setWorshipType(Integer worshipType) {
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
