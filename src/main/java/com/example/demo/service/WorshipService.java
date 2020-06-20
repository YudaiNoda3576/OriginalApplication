package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.WorshipDao;
import com.example.demo.entity.SupporterWorship;
import com.example.demo.entity.Worship;


@Service
public class WorshipService {

	@Autowired
	WorshipDao worshipDao;

	
	public List<SupporterWorship> findScheduleWithSupporter() {
		return this.worshipDao.findScheduleWithSupporter();
	}
	
	@Transactional
	public Worship insert(Worship worship) {
		Worship newWorship = new Worship();
		newWorship.setWorshipType(worship.getWorshipType());
		newWorship.setSchedule(worship.getSchedule());
		newWorship.setRemark(worship.getRemark());
		newWorship.setSupporterId(worship.getSupporterId());
		worshipDao.insert(newWorship);
		
		return worship;
	}
}
