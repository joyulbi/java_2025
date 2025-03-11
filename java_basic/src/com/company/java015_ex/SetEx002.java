package com.company.java015_ex;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

//1. UserInfo2    Dto 클래스만들기  - 속성 : private int no; private  String name; private  int age;
class UserInfo2{
	private int no;
	private String name;
	private int age;
	
	public UserInfo2() { super(); }
	public UserInfo2(int no, String name, int age) { super(); this.no = no; this.name = name; this.age = age; }
	@Override public String toString() { return "UserInfo2 [no=" + no + ", name=" + name + ", age=" + age + "]"; }
	public int    getNo() { return no; }
	public void   setNo(int no) { this.no = no; }
	public String getName() { return name; }
	public void   setName(String name) { this.name = name; }
	public int    getAge() { return age; }
	public void   setAge(int age) { this.age = age; }
	
	// Set, Map 중복허용  1) hashCode  2) equals 
	@Override public int hashCode() { return Objects.hash(no, name, age); }//1. 객체기반 생성확인
	@Override public boolean equals(Object obj) {  //2. 객체안의 값이 같은지 확인
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		UserInfo2 other = (UserInfo2) obj;
		return age == other.age && Objects.equals(name, other.name) && no == other.no;
	} 
}
// Set 동적배열 - 주머니   index(X), 중복허용(X) /  add, get(X), size, remove, contains
public class SetEx002 {
	public static void main(String[] args) {
		//2. users   HashSet만들기
		Set<UserInfo2>  users = new HashSet<>();
		//3. 다음의 데이터 넣기
		users.add(new UserInfo2(1, "아이언맨" , 50) );
		users.add(new UserInfo2(2, "헐크" , 40)  );
		users.add(new UserInfo2(3, "캡틴" , 120) );
		users.add(new UserInfo2(3, "캡틴" , 120) );  // hashCode → equals
		//4. 향상된 for / Iterator 이용해서 데이터 출력
		for( UserInfo2 u   : users) 
		{ System.out.println(u.getNo() + "/" + u.getName()+"/" + u.getAge()); }
		System.out.println();
		System.out.println();
		
		//iterator
		Iterator <UserInfo2> iter=  users.iterator();  // 1.모으기 iter→[1/아이언맨/1, 2/헐크/2]
		while(iter.hasNext()) { //2. 처리대상확인  iter[→1/아이언맨/1, 2/헐크/2]
			UserInfo2 u = iter.next();//3. 꺼내오기  1/아이언맨/1
			System.out.println(u.getNo() + "/" + u.getName()+"/" + u.getAge());
		}
		System.out.println("회원수 > "  + users.size());  //4명  --- 3명
		//System.out.println(users.getClass());  // class java.util.HashSet
		
		//5. 사용자들의 이름 입력받기 - 이름을 입력받으면 해당하는  유저의 자료출력
		Scanner  scanner = new Scanner(System.in);
		System.out.print("원하는 유저의 정보입력 > ");
		String name = scanner.next();
		//set에서 데이터 꺼내와 / 해당데이터의 이름과 입력한값이 같다면 / 해당유저의 자료출력
		iter=  users.iterator(); //1. 모으기
		while(iter.hasNext()) {     //2. 처리대상확인
			UserInfo2 u = iter.next();//3. 꺼내오기
			if(u.getName().equals(name)) {
			     System.out.println(u.getNo() + "/" + u.getName()+"/" + u.getAge());
			}
		}////// 값이 안나옴
	
	}
}
/*
연습문제2)  Collection  Framework
패키지명 : com.company.java015_ex
클래스명 : SetEx002
1. UserInfo2    Dto 클래스만들기  - 속성 : private int no; private  String name; private  int age;
2. users   HashSet만들기
3. 다음의 데이터 넣기
   new UserInfo2(1, "아이언맨" , 50) , 
   new UserInfo2(2, "헐크" , 40) , 
   new UserInfo2(3, "캡틴" , 120), 
   new UserInfo2(3, "캡틴" , 120)

4. 향상된 for / Interator 이용해서 데이터 출력
5. 사용자들의 이름 입력받기 - 이름을 입력받으면 해당하는  유저의 자료출력
*/