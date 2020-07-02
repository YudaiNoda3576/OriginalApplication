package com.example.demo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.dao.EmptyResultDataAccessException;

import com.example.demo.dao.SupporterDao;
import com.example.demo.entity.Supporter;

@RunWith(Enclosed.class)
public class SupporterServiceTest {

	@Mock
	private SupporterDao supporterDao;
	
	@InjectMocks
	private SupporterService supporterSurvice;
	
	@Test
	public void 存在しないIDでは檀家が取得出来ないこと() {
		when(supporterDao.findByTempleId(0)).thenThrow(new EmptyResultDataAccessException(1));
		try {
			List<Supporter> supporter = supporterSurvice.findByTempleId(0);
		} catch(IdNotExistException e) {
			assertEquals(e.getMessage(), "指定された檀徒は存在しません");
		}
	}
}
