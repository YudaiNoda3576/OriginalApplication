package com.example.demo.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import com.example.demo.entity.Supporter_Worship;



@Dao
@ConfigAutowireable
public interface WorshipDao {
		
	@Select
	List<Supporter_Worship> findScheduleWithSupporter(); 
}
