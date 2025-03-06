package com.company.java013;


//Q8 다음 Car4는 DTO목적이다
//8-1 color 접근제어가자 private이므로 getters stters를 작성해 데이터를 셋팅
//8-2 객체의 상태를 표현하는 출력 toString

//Q9 오류해결
class Car4 extends Object{
	private String color;
	public Car4() {super();}
	@Override
	public String toString() {
		return "Car4 [color=" + color + "]";
	}
	public String getColor() { return color; }
	public void setColor(String color) { this.color = color; }
}

public class Repeat003 {
	public static void main(String[] args) {
		Car4 c1 = new Car4();
		c1.setColor("red");
		System.out.println(c1);
		System.out.println(c1.getColor());
	}
}
//Q10 클래스 상속하는 이유 : 코드중복 없애려고
//Q11 상속 형식 : 자식 클래스 extends 부모클래스

