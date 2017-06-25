package org.bigbird.note.Junit;

import org.junit.Assert;
import org.junit.Test;

public class JunitDemoTest1 {
	
	@Test
	public void test1(){
		System.out.println("测试方法1");
		
	}
	@Test
	public void test2(){
		System.out.println("测试方法2");
		double salary=10000;
		Double expect=7100d;
		Double actual=SalaryCompute.compute(salary);		
		//使用断言API测试逻辑
		Assert.assertEquals(expect, actual);
		System.out.println(actual);
	}
	
	@Test
	public void test3(){
		System.out.println("测试方法3");
		
	}
}
