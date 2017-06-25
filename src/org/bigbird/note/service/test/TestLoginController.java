package org.bigbird.note.service.test;
import javax.annotation.Resource;

import org.bigbird.note.controller.user.LoginController;
import org.bigbird.note.entity.NoteResult;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.junit.Assert;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestLoginController {
	
	@Resource
	private LoginController controller;
	
	private MockMvc mockmvc;  	//����API
	
	@Before
	public void init(){
		mockmvc = MockMvcBuilders.standaloneSetup(controller).build();
		
	}
	
	@Test
	public void test1() throws Exception{
		//����һ��post����
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/user/login.do");
		//����������������
		request.param("name", "demo").param("pwd", "1234");
		//����ִ������
		MvcResult mvcResult = mockmvc.perform(request).andReturn();
		//��ȡ��Ӧ���������
		String content = mvcResult.getResponse().getContentAsString();
		System.out.println(content);
		//Ϊ���ö��ԡ���Ҫ��content�ַ���ת��NoteResult����
		ObjectMapper mapper = new ObjectMapper();
		NoteResult noteResult = mapper.readValue(content, NoteResult.class);
		//��ʼ����noteResultʵ�ʷ��ؽ����Ԥ���Ƿ�һ��
		Assert.assertEquals(0, noteResult.getStatus());
	}
}
