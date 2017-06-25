package org.bigbird.note.Junit;

import java.lang.reflect.Method;

import org.bigbird.note.entity.User;
import org.junit.Test;

public class TestIOC {
	
	@Test
	public void test1() throws Exception{
		String className  = "org.bigbird.note.entity.User";
		Class clazz = Class.forName(className);
		Object obj = clazz.newInstance();
		System.out.println(obj);
		Method method = clazz.getMethod("setCn_user_name", String.class);
		System.out.println(method);
		method.invoke(obj, "demo");
		//检测下是否设置了cn_user_name
		User user = (User) obj;
		System.out.println(user);
	}
}
