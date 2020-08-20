package com.example.demo.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;


import com.example.demo.entity.Supporter;

@SpringJUnitConfig
@SpringBootTest
@ActiveProfiles("unit")
public class SupporterServiceTest {

	@Autowired
	private SupporterService supporterService;
	
	@Test
	private void 存在しない寺院IDで検索した時エラーメッセージを表示する() {
		try {
			List<Supporter> list = supporterService.findByTempleId(0);
		} catch(IdNotExistException e) {
			assertEquals(e.getMessage(),"指定された檀徒は存在しません");
		}
	}
}
