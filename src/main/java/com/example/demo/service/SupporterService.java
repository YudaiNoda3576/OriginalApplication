package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.SupporterDao;
import com.example.demo.entity.Supporter;


@Service
public class SupporterService {

	private SupporterDao supporterDao;

	@Autowired	
	public SupporterService(SupporterDao supporterDao) {
		this.supporterDao = supporterDao;
	}
	
	public List<Supporter> findAll() {
		return  this.supporterDao.findAll();
	}
	
	
}
