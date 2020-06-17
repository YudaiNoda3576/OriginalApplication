package com.example.demo.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import com.example.demo.entity.Temple;

@Dao
@ConfigAutowireable
public interface TempleDao {

	@Insert
	int insert(Temple temple);
	
	@Select
	List<Temple> findAll();

}
