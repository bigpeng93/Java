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
	@Before//ÿ�ε���Test����֮ǰ����ִ�и÷���һ��
	public void init(){
		System.out.println("��ʼ������");
		String conf="applicationContext.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
		service = ac.getBean("userServiceImpl",UserService.class);
		
	}
	
	@After//ÿ�ε���Test����֮�󶼻�ִ�и÷���һ��
	public void destroy(){
		System.out.println("�ͷ���Դ����");	
	}
	
	@Test
	public void test1() throws Exception{
		System.out.println("���Է���1");
		NoteResult result = service.checkLogin("demo", "abc");
		Assert.assertEquals("2", result.getStatus());
		Assert.assertEquals("���벻��ȷ", result.getMsg());
	}
	@Test
	public void test2() throws Exception{
		System.out.println("���Է���2");
/*		double salary=10000;
		Double expect=7100d;
		Double actual=SalaryCompute.compute(salary);		
		//ʹ�ö���API�����߼�
		Assert.assertEquals(expect, actual);
		System.out.println(actual);*/
		NoteResult result = service.checkLogin("demo", "1234");
		Assert.assertEquals("0", result.getStatus());
		Assert.assertEquals("�û�����������ȷ", result.getMsg());
	}
	
	@Test
	public void test3() throws Exception{
		System.out.println("���Է���3");
		NoteResult result = service.checkLogin("bbbb", "1234");
		Assert.assertEquals("2", result.getStatus());
		Assert.assertEquals("�û���������", result.getMsg());
	}
}
