package com.company.java010_ex;

class Coffee{
	String name; int price,num;
	
	public Coffee(String name, int price, int num) {
		super();
		this.name = name;
		this.price = price;
		this.num = num;
	}
	public Coffee() {super();this.name="아메리카노"; this.price=2000; this.num=1;}
	void show(){
		System.out.println("======= 커피 =======");
		System.out.println("> 커피정보 : "+name);
		System.out.println("> 커피잔수 : "+num);
		System.out.println("> 커피가격 : "+price);
		}
}
public class ClassEx003 {
	public static void main(String[] args) {
		Coffee a1 = new Coffee("카페라떼",2,4000);
		a1.show();
		Coffee a2 = new Coffee();
		a2.show();
	}

}
