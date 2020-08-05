package com.example.demo.controller;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.flash;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;



import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;



import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Temple;
import com.example.demo.form.TempleForm;
import com.example.demo.service.TempleService;

@Transactional
@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
@AutoConfigureMockMvc
public class TempleControllerTest {

	@MockBean
	TempleService templeServiceMock;

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void 寺院登録用フォームが表示されること() throws Exception {
		mockMvc.perform(get("/signup"))
		       .andExpect(status().isOk())
		       .andExpect(view().name("register/signup.html"));
	}
	@Test
	public void 新規登録が完了したら画面遷移すること() throws Exception {
		mockMvc.perform(post("/signup").param("password", "yudainoda").param("templeName", "林床寺")
				                       .param ("denpmination","臨済宗").param("monkName", "野田義男")
				                       .param("position", "住職").param("postalcode", "444-4444")
				                       .param("address", "愛知県春日井市").param("email", "noda@gmail.com"))
				                       .andExpect(status().isOk())
				                       .andExpect(flash().attribute("success", "登録が完了しました"));
	}

	
	
//  テスト用のエンティティクラスの作成  
	public Temple makeTemple(String password, String templeName, String denomination, 
			String monkName, String position, String postalcode, String address, String email) {
		Temple temple = new Temple();
		
		temple.setPassword(password);
		temple.setTempleName(templeName);
		temple.setDenomination(denomination);
		temple.setMonkName(monkName);
		temple.setPosition(position);
		temple.setPostalcode(postalcode);
		temple.setAddress(address);
		temple.setEmail(email);
		
		return temple;
	}
//	テスト用のフォームクラスの作成
	public TempleForm makeTempleForm(String password, String templeName, String denomination, 
			String monkName, String position, String postalcode, String address, String email) {
		TempleForm templeForm = new TempleForm();
		
		templeForm.setPassword(password);
		templeForm.setTempleName(templeName);
		templeForm.setDenomination(denomination);
		templeForm.setMonkName(monkName);
		templeForm.setPosition(position);
		templeForm.setPostalcode(postalcode);
		templeForm.setAddress(address);
		templeForm.setEmail(email);
		
		return 	templeForm;
	}
}
