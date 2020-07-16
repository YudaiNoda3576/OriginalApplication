package com.example.demo.dao;

import java.util.List;




import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;

import com.example.demo.entity.SupporterWorship;
import com.example.demo.entity.Worship;

import jdk.nashorn.internal.runtime.regexp.joni.SearchAlgorithm;




@Dao
@ConfigAutowireable
public interface WorshipDao {
		
	@Select
	List<SupporterWorship> findScheduleWithSupporter();
	
	@Insert
	int insert(Worship worship);
	
	@Select
	Worship findByWorshipId(Integer worshipId);
	
	@Select
	List<SupporterWorship> searchBySupporterName(String SupporterName);
	
//	お参り予定の完了・未完了判定用のメソッド
	@Update
	int update(Worship worship);
	

}
