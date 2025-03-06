package com.company.java013;
/*
 * Is A
 * 고양이는 동물이다.
 * 개는 동물이다.
	Animal
	↑    ↑
   cat  dog
*/

abstract class Animal { //일반클래스 + 설계
	String name; int age;
	abstract void eat(); //추상 메서드가 있으면 반드시 추상클래스로 만들어줘야함
	abstract void sleep(); //추상 메서드{} 구현부가 없음 - 공통의 속성, 구체적인 내용이 없음
	abstract void poo(); //추상화, 일반화, 설계 : 공통적인 속성, 행동
}
// 고양이는 동물이다 / abstract 구현
class Cat extends Animal{
	@Override void eat() {System.out.println(super.name + "고양이 냠냠!");}
	@Override void sleep() {System.out.println(super.name + "고양이 코!");   }
	@Override void poo() {System.out.println(super.name + "고양이 시원!"); }
}
//강아지는 동물이다 / abstract 구현
class Dog extends Animal{
	
	@Override void eat() {System.out.println(super.name + "강아지 냠냠!");}
	@Override void sleep() {System.out.println(super.name + "강아지 코!");   }
	@Override void poo() {System.out.println(super.name + "강아지 시원!"); }
}

public class Abstract001 {
	public static void main(String[] args) {
		//1.abstract class :일반클래스 + 설계
		//Animal ani = new Animal(); X new 메모리빌리고, 갹체생성 / Animal()초기화 / {} 구현부없음
		Animal ani=null;
		ani = new Cat();//부모 = 자식,업캐스팅,타입캐스팅 필요없음
		ani.name="sally"; ani.eat();
		
		ani = new Dog();//부모 = 자식,업캐스팅,타입캐스팅 필요없음
		ani.name="alpha"; ani.eat();
		System.out.println(ani);
		
		//2.사용목적
		Animal[]arr= {new Cat(),new Cat(),new Dog(),new Dog()};
		int cnt = 0;
		for(Animal a:arr) {a.name="ani"+ ++cnt; a.eat();}
	}
}


