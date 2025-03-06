package com.company.java013;
//Q16.
/*1)상속도 그리기
	Object 
	  ↑
	 Papa  {money=10000 / sing() GOD-거짓말}
	  ↑
	 Son   {money=1500 / sing() 빅뱅-거짓말}
*/
//2) 각 클레스에서 사용 할 수 있는 멤버변수 / 멤버메서드
class Papa extends Object{  
    int money = 10000;     
	public Papa() { super(); }
	public void sing() {  System.out.println("GOD-거짓말");  }
}// end class
class Son extends Papa{ 
	int money = 1500;
	public Son() { super(); }
	@Override public void sing() {  System.out.println("빅뱅-거짓말"); }
} // end class
public class Repeat006 {
	public static void main(String[] args) { 
		Papa mypapa = new Son();    
		//8) 부모 = 자식 관계 / 업,다운 캐스팅 선택/ 타입캐스팅 필요여부
		//>> 부모는 자식을 담을 수 잇다. 업캐스팅/ 타입캐스팅 필요 X
		
		//3)Papa mypapa 의미? {money=10000 / sing() GOD-거짓말} 쓸 수 있게 해줄게
		
		//4)인스턴스화한 실제 메모리 빌려온그림
		// 1번지 {money=1500 / sing() 빅뱅-거짓말} - {money=10000 /-----------}
		//							[여기서부터								여기까지보장]
		//mypapa 1번지 {money=1500 / sing() 빅뱅-거짓말} - {money=10000 /-----------}
		System.out.println(mypapa.money); //5)  출력   
		mypapa.sing();  //6) 출력 
		//7) mypapa.money 를 이용해서 1500 출력되게 해주세요.
		System.out.println(((Son)mypapa).money);
	}
}
