package org.bigbird.note.Junit;

public class SalaryCompute {
	public static double compute(double salary){
		if(salary>3000){
			return salary*0.7;
			
		}else{
			return 0;
		}
		
	}
}
