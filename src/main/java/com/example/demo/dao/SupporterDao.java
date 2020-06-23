package com.example.demo.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import com.example.demo.entity.Supporter;

@Dao
@ConfigAutowireable
public interface SupporterDao {

	@Insert
	int insert(Supporter supporter);

	@Select
	List<Supporter> findByTempleId(Integer templeId);
}