package com.company.java010;

class Product{
	String name;
	int price;
	//alt + shift + s (밑에서 3번째)
	public Product(String name, int price) {super();this.name = name;this.price = price;}
	//alt + shift + s (밑에서 2번째)
	//Stirng 문자열은 null로 초기화 / int는 0으로 초기화
	public Product() {super();System.out.println("원하는 값으로 초기화 - 수동시 컴파일러 자동생성 취소");}
	@Override //alt + shift + s (밑에서 4번째)
	//@Override - 자식 클래스(Product)에 맞게 수정 -  값 출력
	public String toString() {return "Product [name=" + name + ", price=" + price + "]";}
}

public class Class004 {
	public static void main(String[] args) {
		Product p1 = new Product();
		System.out.println(p1);
	}

}
/*
------------------------------- runtime 
[method]	Product.class, Class004.class #step1
---------------------------------------------
[heap]               		| [stack]
1번지:{name=null, price=0}	← p1
					 		| [main] #step2
---------------------------------------------
*/