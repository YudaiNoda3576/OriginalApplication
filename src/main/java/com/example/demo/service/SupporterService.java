package com.example.demo.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.SupporterDao;
import com.example.demo.entity.Supporter;


@Service
public class SupporterService {

	private SupporterDao supporterDao;

	@Autowired	
	public SupporterService(SupporterDao supporterDao) {
		this.supporterDao = supporterDao;
	}
	

	
	@Transactional
	public Supporter insert(Supporter supporter) {
		supporterDao.insert(supporter);
		return supporter;
	}
	
	public List<Supporter> findByTempleId(Integer templeId) {
		
		return this.supporterDao.findByTempleId(templeId);
		
	}
	
}