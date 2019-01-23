package com.app;


import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.app.controller.MessageController;
import com.app.service.MessageService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class MessageTest {

	@Autowired
	private MockMvc mock;
	
	@Mock
	private MessageService service;
	
	@InjectMocks
	private MessageController controller;
	
	@Test
	public void testCount() throws Exception {
		mock
			.perform(MockMvcRequestBuilders.get("/count"))
			.andExpect(status().isOk())
			.andExpect(content().string("10"))
			.andDo(print());
	}
	
	@Test
	public void testGet4th() throws Exception {
		mock
			.perform(MockMvcRequestBuilders.get("/get4th"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.id", is(4)))
			.andExpect(jsonPath("$.userId", is(1)))
			.andExpect(jsonPath("$.title", is("1800Flowers")))
			.andExpect(jsonPath("$.body", is("1800Flowers")))
			.andDo(print());
	}
	
}
