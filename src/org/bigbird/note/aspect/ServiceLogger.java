package org.bigbird.note.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component//扫描，将组件扫描到Spring容器
@Aspect //将当前组件设置为切面组件
public class ServiceLogger {
	
	@Before("within(org.bigbird.note.service..*)")
	public void slogger(){		
		System.out.println("进入Service方法");
	}
}
