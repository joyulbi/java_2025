package com.company.java009_ex;

class Student001{
	//속성 - 멤버변수
	String name; int no,kor,eng,math,total; double avg;
	
	void info() {
		//total = this.kor+this.eng+this.math;
		//avg = total/3;
		System.out.println("이름 : "+this.name);
		System.out.println("총점 : "+(this.kor+this.eng+this.math));
		System.out.printf("평균 : %.2f \n",((double)this.kor+this.eng+this.math)/3f);
		System.out.println("=================================");}
}


public class ClassEx001 {
	public static void main(String[] args) {
		Student001 s1 = new Student001(); // 1.new(공간,객체생성) 2.Student001() 초기화 --> int는 0으로 String도 빈 값으로 등등 3. s1지번
		s1.name="first"; s1.no=11; s1.kor=100; s1.eng=100; s1.math=99;
		s1.info();
		Student001 s2 = new Student001();
		s2.name="Second"; s2.no=11; s2.kor=90; s2.eng=88; s2.math=90;
		s2.info();
	}
}
/*	클래스는 설계도 - 인스턴스화( heap - new - 객체생성 )를 통해 - 객체(객체들 s1,s2,s3 뭉쳐서 표현) / 인스턴스(각각의 s1,name,s2) 
----------------------------------------- [runtime data area]
[method : (정보, static, final - 공용 정보)]  Student001.class / ClassEx001.class
-----------------------------------------
[heap : 동적]	  									   		 |[stack : 잠깐 빌리기]
20번째줄 : 1번지 {name=first, no=11, kor=100, eng=100, math=99} ← s1 : 1번지
19번째줄 : 1번지 {name=null, no=0, kor=0, eng=0, math=0} ← s1 : 1번지
													  | main
-----------------------------------------
*/