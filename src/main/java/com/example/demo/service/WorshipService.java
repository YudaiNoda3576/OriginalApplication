package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.WorshipDao;
import com.example.demo.entity.Worship;

@Service
public class WorshipService {

	@Autowired
	WorshipDao worshipDao;

	public List<Worship> findBySupporterId(Integer supporterId) {
		return this.worshipDao.findBySupporterId(supporterId);
	}
}
