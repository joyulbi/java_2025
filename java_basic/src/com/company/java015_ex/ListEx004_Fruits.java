package com.company.java015_ex;

import java.util.ArrayList;
import java.util.Scanner;

//1. Fruits  Dto 클래스만들기    
//    속성 :  private int no;   private  String name; private  int price;
class Fruits{
	private  int no;   
	private  String name; 
	private  int price;
	
	public Fruits() { super(); }
	public Fruits(int no, String name, int price) { super(); this.no = no; this.name = name; this.price = price; }
	
	@Override public String toString() { return "Fruits [no=" + no + ", name=" + name + ", price=" + price + "]"; }
	
	public int    getNo() { return no; }
	public void   setNo(int no) { this.no = no; }
	public String getName() { return name; }
	public void   setName(String name) { this.name = name; }
	public int    getPrice() { return price; }
	public void   setPrice(int price) { this.price = price; }
}

public class ListEx004_Fruits {
	public static void main(String[] args) {
//	2. fruits     ArrayList 만들기  
		ArrayList<Fruits>  fruits = new ArrayList<>();
		
//	3. 다음의 데이터 넣기  / index(순서), 중복허용  / add, get, size, remove, contains
		fruits.add(  new Fruits(1, "apple" , 2000) );
		fruits.add(  new Fruits(2, "banana" , 2500) );
		fruits.add(  new Fruits(3, "coconut" , 4500) );
		
//	4. for+size / 향상된 for 이용해서 데이터 출력
		for(int i=0; i<fruits.size(); i++){
			Fruits temp = fruits.get(i);   //0,1,2
			System.out.println(temp.getNo() + "/" +temp.getName() +"/" +temp.getPrice());
		}
		
		for(Fruits temp  : fruits ){
			System.out.println(temp.getNo() + "/" +temp.getName() +"/" +temp.getPrice());
		}
//	5. 1,2,3 과일정보를 입력하시오. - 번호을 입력받으면 해당하는  과일정보의 자료출력
		Scanner scanner = new Scanner(System.in);
		String [] fruitinfo = {"사과는 빨갛다" , "바나나는 노랗다" , "코코넛은 코코하다"};//0,1,2
		System.out.print("1,2,3 원하는 과일정보 번호를 입력하시오.");  
		int num = scanner.nextInt();
		 
		int find =-1;
		//         과일꺼내오기->과일번호 == 입력한값  
		//	if( fruits.get(0).getNo() ==num  ) { find=0; }
		//	if( fruits.get(1).getNo() ==num  ) { find=1; }
		for(int i=0; i<fruits.size(); i++) {
			if( fruits.get(i).getNo() ==num  ) { find=i;  break; }  // 찾았다면 나오기
		}
		
		System.out.println("번호 : " + fruits.get(find).getNo());
		System.out.println("이름 : " + fruits.get(find).getName());
		System.out.println("가격 : " + fruits.get(find).getPrice());
		System.out.println( fruitinfo[find] );
	}
}

//> 1,2,3 과일정보를 입력하시오.   _예) 2
//번호: 2,   이름 : banana, 가격:2500
//바나나는 노랗다
/*
연습문제4)  Collection  Framework
패키지명 : com.company.java015_ex
클래스명 : ListEx004
1. Fruits  Dto 클래스만들기    
    속성 :  private int no;   private  String name; private  int price;
2. fruits     ArrayList 만들기
3. 다음의 데이터 넣기
   new Fruits(1, "apple" , 2000) ,  new Fruits(2, "banana" , 2500) ,  new Fruits(3, "coconut" , 4500)
4. for+size / 향상된 for 이용해서 데이터 출력
5. 1,2,3 과일정보를 입력하시오. - 번호을 입력받으면 해당하는  과일정보의 자료출력
   String [] fruitinfo = {"사과는 빨갛다" , "바나나는 노랗다" , "코코넛은 코코하다"};

> 1,2,3 과일정보를 입력하시오.   _예) 2
번호: 2,   이름 : banana, 가격:2500
바나나는 노랗다

*/





