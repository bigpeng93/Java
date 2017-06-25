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
	
	private MockMvc mockmvc;  	//测试API
	
	@Before
	public void init(){
		mockmvc = MockMvcBuilders.standaloneSetup(controller).build();
		
	}
	
	@Test
	public void test1() throws Exception{
		//创建一个post请求
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/user/login.do");
		//给请求添加请求参数
		request.param("name", "demo").param("pwd", "1234");
		//发送执行请求
		MvcResult mvcResult = mockmvc.perform(request).andReturn();
		//获取相应结果的内容
		String content = mvcResult.getResponse().getContentAsString();
		System.out.println(content);
		//为了用断言。需要将content字符串转成NoteResult对象
		ObjectMapper mapper = new ObjectMapper();
		NoteResult noteResult = mapper.readValue(content, NoteResult.class);
		//开始断言noteResult实际返回结果和预期是否一致
		Assert.assertEquals(0, noteResult.getStatus());
	}
}
