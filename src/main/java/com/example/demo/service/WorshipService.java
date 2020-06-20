package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.WorshipDao;
import com.example.demo.entity.SupporterWorship;


@Service
public class WorshipService {

	@Autowired
	WorshipDao worshipDao;

	
	public List<SupporterWorship> findScheduleWithSupporter() {
		return this.worshipDao.findScheduleWithSupporter();
	}
}
