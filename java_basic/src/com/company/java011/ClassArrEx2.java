package com.company.java011;

import com.company.java011_ex.*; //모든 클래스들 다
import com.company.java011_ex.Score2;
import com.company.java011_ex.Score2Print;
import com.company.java011_ex.Score2process;

public class ClassArrEx2 {
	public static void main(String[] args) {
		////// MODEL
		Score2[] std = new Score2[3];  
	   // 0번째에는 아이언맨 정보넣기  - "아이언맨", 100, 100, 100
	   // 1번째에는 아이언맨 정보넣기  - "헐크", 90, 60, 80
	   // 2번째에는 아이언맨 정보넣기  - "블랙팬서", 20, 60, 90
		std[0]=new Score2("아이언맨", 100, 100, 100);
		std[1]=new Score2("헐크", 90, 60, 80);
		std[2]=new Score2("블랙팬서", 20, 60, 90);
	      
	   ////// CONTROLLER - 처리 해결사 Controller)
	   //리턴값 매서드명(파라미터){}
		System.out.println("main 주소확인 : "+System.identityHashCode(std));
		Score2process process = new Score2process();
		process.process_avg(std); 
		process.process_pass(std);  
	   
	   ////// VIEW       - CONSOLE , WEB
		Score2Print  print = new Score2Print();
		print.show(std);  
	}
}

