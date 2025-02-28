package com.company.java010_ex;

class Score{
	String stdid; int kor,eng,math,total; double avg;   
	Score(String stdid, int kor, int eng, int math) {
		this.stdid = stdid;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	int total() { return this.kor+this.eng+this.math;}
	double avg() {return (this.kor+this.eng+this.math)/3f;}
	void info() {
		System.out.println("학번"+"\t"+"국어"+"\t"+"영여"+"\t"+"수학"+"\t"+"총합"+"\t"+"평균");
		System.out.println(this.stdid+"\t"+this.kor+"\t"+this.eng+"\t"+this.math+"\t"+total()+"\t"+String.format("%.2f",avg()));
	}
}
public class ClassEx006 {
	public static void main(String[] args) {
		Score s1= new Score("std1234" , 100, 100 , 99 ); 
		 s1.info();
	}
}
