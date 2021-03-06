package com.example.demo.service;

import java.util.List;


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

	@Transactional
	public Temple create(Temple temple) {
		Temple newTemple = new Temple();
		newTemple.setTempleId(temple.getTempleId());
		newTemple.setPassword(passwordEncoder.encode(temple.getPassword()));
		newTemple.setTempleName(temple.getTempleName());
		newTemple.setDenomination(temple.getDenomination());
		newTemple.setMonkName(temple.getMonkName());
		newTemple.setPosition(temple.getPosition());
		newTemple.setPostalcode(temple.getPostalcode());
		newTemple.setAddress(temple.getAddress());
		newTemple.setEmail(temple.getEmail());
		
		templeDao.insert(newTemple);
		return temple;
	}


	public Temple findByLoginId(String templeId)  {
		return templeDao.findByLoginId(templeId);
	}
}
