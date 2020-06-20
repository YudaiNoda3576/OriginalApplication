package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.WorshipDao;
import com.example.demo.entity.Supporter_Worship;


@Service
public class WorshipService {

	@Autowired
	WorshipDao worshipDao;

	
	public List<Supporter_Worship> findScheduleWithSupporter() {
		return this.worshipDao.findScheduleWithSupporter();
	}
}
