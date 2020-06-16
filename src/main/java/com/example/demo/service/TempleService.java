package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.TempleDao;
import com.example.demo.entity.Temple;

@Service
public class TempleService {

	private TempleDao templeDao;
	
	@Autowired
	public TempleService(TempleDao templeDao) {
		this.templeDao = templeDao;
	}
	
	@Transactional
	public Temple create(Temple temple) {
		templeDao.insert(temple);
		return temple;
	}
}
