package com.example.demo.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;

import com.example.demo.entity.Supporter;


@Dao
@ConfigAutowireable
public interface SupporterDao {

	@Insert
	int insert(Supporter supporter);
	@Update
	int update(Supporter supporter);
//	IDに紐付く檀徒情報の削除
//	@Delete(sqlFile = true)
//	int deleteById(Supporter supporter);

//	寺院Idに紐づく檀徒の一覧を取得するメソッド
	@Select
	List<Supporter> findByTempleId(Integer templeId);

//	檀信徒を一見取得するメソッド
	@Select
	Supporter findBySupporterId(Integer supporterId);
}