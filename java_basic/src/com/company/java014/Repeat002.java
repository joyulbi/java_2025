package com.company.java014;

import java.util.ArrayList;

/* 1. 클래스는 부품객체
 * 2. 멤버변수 / 멤버함수 
 * Q2. 상속도
	Object								Object(){#3}#4
	  ↑
	 Papa	 money = 10 / toString		Papa(){#2}#5
	  ↑
	 Son 	 money=150,car=2 / toString	Son(){#1}#6 @Override
*/

class Papa{
	int money = 10;
	public Papa() { super();  }
	public Papa(int money) { super(); this.money = money; }
	@Override public String toString() { return "Papa [money=" + money + "]"; }	
}

class Son extends Papa{
	int money=150;
	int car=2;
	public Son() { super();  }
	public Son(int money) { super(money);  }
	public Son(int money, int car) { super(); this.money = money; this.car = car; }
	@Override public String toString() { return "Son [money=" + money + ", car=" + car + "]"; }
}

public class Repeat002 {
	public static void main(String[] args) {
		
		Papa p1 = new Papa(); // [money=10,toString] = 1번지 Papa(){money=10/toString}
		System.out.println(p1); //Q3. Papa [money=10]
		
		
		Son s2 = new Son(); 
		//                                                        [여기서부터            여기까지]
		//[money=150,car=2/toString]-[money=10/------] = 2번지 Son(){money=150,car=2/toString}
		System.out.println(s2);//Q4. Son [money=150, car=2]
		
		
//		Son s3 = new Papa(); //Q5.컴파일 오류 타입이 맞지않음 
		//Son s3[money=150,car=2/toString]-[money=10/------] = Papa{money=10/------}
		//		[보장범위]										  	   [청소범위   둘이 안맞음]
		
		Papa p4 = new Son();
		System.out.println(p4);//Q6-1.Son [money=150, car=2]
		//                                                            [여기서부터                  여기까지]
		//Papa p4{int money=10, toSting } = Son {int money=150,car=2, toSting }-{int money=10, ------ } 
		//toString 값은 오버라이딩 돼서 덮여씌워짐
		System.out.println(p4.money);//Q6-2 10
		// 참조변수타입 기준이므로 10이 출력 p4자체는 Papa타입임
		
		
		Papa p5 = new Son();  //1. 부모 = 자식 / 업캐스팅 / 타입캐스팅 필요 X
		Son s5 = (Son)p5;  //2. 자식 = 부모 / 다운캐스팅 / 타입캐스팅 필요 O / 부모는 자식생성자를 호출한 적이 있어야 한다.
		//Son s5 [int money=150,car=2, toSting ]-[int money=10, ------]
		//p5 = Son(){int money=150,car=2, toSting }-Papa{int money=10, ------}	
		System.out.println(s5);//Q7-1. Son [money=150, car=2]
		//                                                          [여기서부터                    여기까지]
		//Papa s5{int money=10, toSting }= Son{int money=150car=2, toSting} --{int money=10, ------ }
		
		
		System.out.println(s5.money);//Q7-2.150
		System.out.println(((Papa)s5).money);// 10
		System.out.println(((Papa)s5).toString()); //오버라이딩돼서 자식 거 나옴
		// Son에서 Papa의 toString 호출
		
		///////////////////////////////////////////////////////////////////////
		ArrayList<String> list = new ArrayList<>(); //다음주지진행 ctrl + shift + o
		//public class ArrayList<E> extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, Serializable
		//////////////////////////////////////////////////////////////////////
	}
}
//Q8 오버로딩과 오버라이딩
// 오버로딩 : 메서드의 이름을 같게, 알규먼트 자료형과 갯수를 다르게해 구분/ 비슷한 기능
// 오버라이딩 : 상속시 자식클래스에서 맞게 메서드를 수정

