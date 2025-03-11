package java_test002;


//1. 클래스는 부품객체
//2. 상태(멤버변수)와 행위(멤버함수)

class Coffee{
	String name; int price; int num;

	public Coffee() {
		super();
		this.name="아메리카노";
		this.num=1;
		this.price=2000;
	}

	public Coffee(String name, int price, int num) {
		super();
		this.name = name;
		this.price = price;
		this.num = num;
	}
	void show() {
		System.out.println("======커피"+"\n커피명 : "+this.name+"\n커피잔수 : "+this.num+"\n커피 가격 : "+this.price);
	}
	
}
public class Test001 {
	public static void main(String[] args) {
		Coffee a1 =new Coffee("카페라떼",2,4000);
		a1.show();
		Coffee a2 =new Coffee();
		a2.show();
	}
}
/**************
Repeat001.java                   <  javac Repeat001.java
Coffee.class , Repeat001.class   <  java  Repeat001 
------------------------------------------------------------
[method]
[1번지]Coffee.class  
[2번지]Repeat001.class  ##1
------------------------------------------------------------
[heap]                                |       [stack]
[2000]번지                         <----[a2 | 2000번지]
{ name="아메리카노", num=1 , price=1500 }                                   
[1000]번지                         <----[a1 | 1000번지]
{  name="까페라떼", num=2, price=4000  }   [main          ]
------------------------------------------------------------
*/
