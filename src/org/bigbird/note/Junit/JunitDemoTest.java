package org.bigbird.note.Junit;

import org.bigbird.note.entity.NoteResult;
import org.bigbird.note.service.UserService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JunitDemoTest {
	UserService service;
	@Before//每次调用Test方法之前都会执行该方法一次
	public void init(){
		System.out.println("初始化代码");
		String conf="applicationContext.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
		service = ac.getBean("userServiceImpl",UserService.class);
		
	}
	
	@After//每次调用Test方法之后都会执行该方法一次
	public void destroy(){
		System.out.println("释放资源代码");	
	}
	
	@Test
	public void test1() throws Exception{
		System.out.println("测试方法1");
		NoteResult result = service.checkLogin("demo", "abc");
		Assert.assertEquals("2", result.getStatus());
		Assert.assertEquals("密码不正确", result.getMsg());
	}
	@Test
	public void test2() throws Exception{
		System.out.println("测试方法2");
/*		double salary=10000;
		Double expect=7100d;
		Double actual=SalaryCompute.compute(salary);		
		//使用断言API测试逻辑
		Assert.assertEquals(expect, actual);
		System.out.println(actual);*/
		NoteResult result = service.checkLogin("demo", "1234");
		Assert.assertEquals("0", result.getStatus());
		Assert.assertEquals("用户名和密码正确", result.getMsg());
	}
	
	@Test
	public void test3() throws Exception{
		System.out.println("测试方法3");
		NoteResult result = service.checkLogin("bbbb", "1234");
		Assert.assertEquals("2", result.getStatus());
		Assert.assertEquals("用户名不存在", result.getMsg());
	}
}
