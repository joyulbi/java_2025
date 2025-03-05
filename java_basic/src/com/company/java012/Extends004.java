package com.company.java012;
//1. 클래스는 부품객체
//2. 상태(멤버변수)와 행위(멤버함수)
/*3. 상속 - 클래스 재사용(재활용)
  	 오버라이드(@Override) - 부모 메서드 나한테 맞게 수정
  		
  					object
  			↑					↑
  	Grand(one(),two())	Aunt(name,toString())
  		↑		  ↑
   	Father	    Uncle
    (three())   (four()/one(),two())
*/

class Grand{
	public void one() {System.out.println("grand:one");}
	public void two() {System.out.println("grand:two");}
}//end Grand
class Aunt{
	String name ="MiMi";
	@Override public String toString() {return name + "옆집이모클래스";}
}//end Aunt
class Father extends Grand{
	public void three() {System.out.println("father:three");}
}//end Father
class Uncle extends Grand{
	public void four() {System.out.println("uncle:four");}
	public void one() {super.one(); System.out.println("uncle:one");}
	public void two() {super.two(); System.out.println("uncle:two");}
} //end Uncle
public class Extends004 {
	public static void main(String[] args) {
		Father father = new Father(); father.three(); father.two(); father.one();
		//↑ Object(){#3  }#4 객체틀만들고
		//↑  Grand(){#2  }#5 one(), two() 사용가능
		//↑ Father(){#1  }#6 three() 	  사용가능
		System.out.println(); System.out.println();
		
		Uncle uncle = new Uncle(); uncle.four(); uncle.two(); uncle.one();
		//↑ Object(){#3  }#4 객체틀만들고
		//↑  Grand(){#2  }#5 		 one(), two() 사용가능 Override : 부모 클래스와 같은 메서드 자식에게 맞게 재정
		//↑  Uncle(){#1  }#6 four(), one(), two() 사용가능 우선순위 - 자식메서드 우선(내거) 우선
		System.out.println(); System.out.println();
		
		Aunt aunt = new Aunt();
		System.out.println(aunt);
		//System.out.println(aunt.toString()); 
	}
}
