package org.bigbird.note.Junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class) //该类是一个junit套件，可以调用执行多个Test类型
@SuiteClasses({JunitDemoTest.class,JunitDemoTest1.class})
public class JunitSuiltTest {
	
	
}
