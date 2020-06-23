package com.example.demo.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.SupporterDao;
import com.example.demo.dao.WorshipDao;
import com.example.demo.domain.WorshipOpts;
import com.example.demo.entity.SupporterWorship;
import com.example.demo.entity.Worship;


@Service
public class WorshipService {

	@Autowired
	WorshipDao worshipDao;
	@Autowired
	SupporterService supporterService;
	

	
	public List<SupporterWorship> findScheduleWithSupporter() {
		return this.worshipDao.findScheduleWithSupporter();
	}
//	例外のハンドリングは基本的にController
//	Serviceはシンプルに記述　→　誰に使われるか分からない/できるだけ曖昧に書く
	@Transactional
	public Worship insert(Worship worship) {  
		worshipDao.insert(worship);
		return worship;
  }
}
