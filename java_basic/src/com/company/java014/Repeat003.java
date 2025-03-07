/*
Q9. abstract란? 추상화, 일반화, 공통의 기능 -> IS A 고양이는 동물이다.

Q10. interface란? 실체화 관계 -> can do this! 약속할게 구현객체를 통해서 이 서비스를 약속

Q11. abstract 과 interface의 공통점과 차이점은?
	공통점 : 자식클래스를 통해서 설계 부분을 구현한다.
	차이점 : 추상화 정도가 interface가 높다
		   abstract 일반클래스 + 설계도
		   interface 설계도 
		   멤버변수는 public static final이 붙은 상수
		   멤버함수는 public abstract abstract메서드
*/

package com.company.java014;
//Q12
/*
	  Fruit
   ↑    ↑      ↑
Apple Banana coconut  -  myfruit() -@Override
 * */
abstract class Fruit{
	@Override public String toString() { return "Fruit [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]"; } 
	public abstract void myfruit();
}
class Apple extends Fruit{
	@Override public void myfruit() { System.out.println("사과는 빨갛다");}
}
class Banana extends Fruit{
	@Override public void myfruit() { System.out.println("바나나는 노랗다"); }
}
class Coconut extends Fruit{
	@Override public void myfruit() {  System.out.println("코코넛은 코코하다");}
}
public class Repeat003 {
	public static void main(String[] args) {
		Fruit[]fruits = {new Apple(),new Banana(),new Coconut()};
		//부모 = 자식들
		//한개의 자료형(부모)으로 여러개의 객체들(자식들)을 관리
		for(int i = 0;i<fruits.length;i++) {fruits[i].myfruit();}
		for(Fruit f:fruits) {f.myfruit();}
	}

}
