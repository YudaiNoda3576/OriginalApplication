package com.example.demo.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.SupporterDao;
import com.example.demo.dao.WorshipDao;
import com.example.demo.entity.SupporterWorship;
import com.example.demo.entity.Worship;


@Service
public class WorshipService {

	@Autowired
	WorshipDao worshipDao;
	@Autowired
	SupporterService supporterService;
	@Autowired
	SupporterDao supporterDao;
	

	
	public List<SupporterWorship> findScheduleWithSupporter() {
		return this.worshipDao.findScheduleWithSupporter();
	}
	
	@Transactional
	public Worship insert(Worship worship) {  
		Worship newWorship = new Worship();  
//		存在チェック　そのIDは存在するのか？というチェック
		if(isExistSupporterId()) {
		newWorship.setWorshipType(worship.getWorshipType());
		newWorship.setSchedule(worship.getSchedule());
		newWorship.setRemark(worship.getRemark());
		newWorship.setSupporterId(worship.getSupporterId());
		worshipDao.insert(newWorship);
		return newWorship;
	} else {
		throw new IdNotExistException("指定されたIDの檀徒は存在しません");
	}
  }

	private static boolean isExistSupporterId() {
		supporterDao.findSupporterId();
		
		return false;
	}
}
