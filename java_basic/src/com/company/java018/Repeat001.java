package com.company.java018;

import java.util.Arrays;

class Milk{
	private String name;
	private int price;
	public Milk() { super();  }
	public Milk(String name, int price) { super(); this.name = name; this.price = price; }
	public String getName() { return name; } public void setName(String name) { this.name = name; }
	public int getPrice() { return price; } public void setPrice(int price) { this.price = price; }
	@Override public String toString() { return "Milk [name=" + name + ", price=" + price + "]"; } 
}

class MilkPrint{
	void show(Milk[] milks) {
		for(Milk e:milks) {
			System.out.println(e.getName()+" / "+e.getPrice());
		}
	}	
}

public class Repeat001 {
	public static void main(String[] args) {
		//Q3
		Milk m1 = new Milk("choco", 1200);
		System.out.println(m1); // 출력된 결과 : choco / 1200
		Milk m2 = new Milk(); m2.setName("white"); m2.setPrice(1300);
		System.out.println(m2);
		System.out.println();
		
		//Q4
		Milk []milks = new Milk[3];   
		milks[0] = new Milk("white",1000);
		milks[1] = new Milk("choco",1200);
		milks[2] = new Milk("banana",1500);
		MilkPrint  print = new MilkPrint();   
		print.show(milks);	
	}

}
/*Q3.  class(1) 필요한 자료의 묶음.
 		 1. 메인은 다음과 같다.
 		 	Milk m1 = new Milk("choco" , 1200);
 		 	System.out.println( m1 );  // 출력된 결과 : choco / 1200
 		 	Milk m2 = new Milk();
 		 	System.out.println( m2 );  // 출력된 결과 : white / 1300
 		 	
		 2.	Milk 클래스를 구현하시오 
			  	클래스의 기능 : 데이터를 받아서 전달하는 기능  (DTO)
				1) 멤버변수    private  name이름 ,  private  price가격      
				2) 생성자      기본생성자 : 
						   필드생성자 : 이름,  , 가격을 입력받아 처리해주는 생성자	
				3) 멤버함수  ---		

Q4.  class(2) 클래스 배열
 		 1. 메인은 다음과 같다.
			Milk []milks = new Milk[3];   
			milks[0] = new Milk("white",1000);
			milks[1] = new Milk("choco",1200);
			milks[2] = new Milk("banana",1500);
			
			MilkPrint  print = new MilkPrint();   
			print.show(  milks     );	
			// 출력된 결과 : 
			 * white  / 1000
			 * choco  / 1200
			 * banana / 1500 
			 
		 2.	MilkPrint 클래스를 구현하시오 */