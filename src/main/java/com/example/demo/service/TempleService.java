package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.TempleDao;
import com.example.demo.entity.Temple;

@Service
public class TempleService {
	@Autowired
	private PasswordEncoder passwordEncoder;

	private TempleDao templeDao;

	@Autowired
	public TempleService(TempleDao templeDao) {
		this.templeDao = templeDao;
	}

//	@Transactional
//	public Temple create(Temple temple) {
//		templeDao.insert(temple);
//		return temple;
//	}
	
	@Transactional
	public Temple create(Temple temple) {
		Temple newTemple = new Temple();
		newTemple.setTempleId(temple.getTempleId());
		newTemple.setPassword(passwordEncoder.encode(temple.getPassword()));
		newTemple.setTempleName(temple.getTempleName());
		newTemple.setDenomination(temple.getDenomination());
		newTemple.setName(temple.getName());
		newTemple.setPosition(temple.getPosition());
		newTemple.setPostalcode(temple.getPostalcode());
		newTemple.setAdress(temple.getAdress());
		newTemple.setEmail(temple.getEmail());
		
		templeDao.insert(newTemple);
		return temple;
	}
}
