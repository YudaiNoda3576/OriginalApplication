package com.example.demo.dao;


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
	
<<<<<<< HEAD
=======


>>>>>>> master
	@Select
	Temple findByLoginId(String templeId);

}
