package org.bigbird.note.aspect;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ExceptionLogger {
	
	@AfterThrowing(throwing="ex",pointcut="within(org.bigbird.note.controller..*)")
	public void log(Exception ex){
		//���쳣��Ϣд���ļ�
		System.out.println("��¼�쳣��Ϣ��"+ex);
		try {
			FileWriter fw = new FileWriter("D:\\error.txt");
			PrintWriter out = new PrintWriter(fw);
			ex.printStackTrace(out);
			out.flush();
			out.close();
			fw.close();
		} catch (IOException e) {
			System.out.println("��¼�쳣��Ϣʧ��");
		}		
	}
}
