package com.company.java016;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

//Q2. 1. UserInfo    Dto 클래스만들기    - 속성 :  private  String name; private  int age;

class UserInfo{
	private String name;
	private int age;
	
	public UserInfo() { super(); }
	public UserInfo(String name, int age) { super(); this.name = name; this.age = age; }
	@Override public String toString() { return "UserInfo [name=" + name + ", age=" + age + "]"; }
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public int getAge() { return age; }
	public void setAge(int age) { this.age = age; }
	
}
public class Repeat001 {
	public static void main(String[] args) {
		
//		2. users ArrayList 만들기
		ArrayList<UserInfo> users = new ArrayList<>();
		
//		3. 다음의 데이터 넣기
//		   new UserInfo("아이언맨" , 50) , new UserInfo("헐크" , 40) , new UserInfo("캡틴" , 120)
		users.add(new UserInfo("아이언맨",50));
		users.add(new UserInfo("헐크" , 40));
		users.add(new UserInfo("캡틴" , 120));
		
//		4. for+size / 향상된 for 이용해서 데이터 출력
		for(UserInfo u : users) {System.out.println(u.getName()+"/"+u.getAge());}
		
		System.out.println();
		System.out.println();
		for(int i =0; i<users.size();i++) {
			UserInfo u = users.get(i);
			System.out.println(u.getName()+"/"+u.getAge());
		}
		
		
//		5. sets  HashSet 만들기
//		주머니 :add, 향상된 for/Iterator, size, remove, contains
		HashSet<UserInfo> sets = new HashSet<>();
		
//		6. 다음의 데이터 넣기 new UserInfo("아이언맨" , 50) , new UserInfo("헐크" , 40) , new UserInfo("캡틴" , 120)
		sets.add(new UserInfo("아이언맨",50));
		sets.add(new UserInfo("헐크" , 40));
		sets.add(new UserInfo("캡틴" , 120));
		
//		7. for+size / 향상된 for 이용해서 데이터 출력
		for(UserInfo s: sets) {System.out.println(s.getName()+"/"+s.getAge());}
		System.out.println();
		System.out.println();
		
//		1. sets 모으기 - iterator /2. 처리대상확인 - hasNext /3. 꺼내오기 - next
		Iterator<UserInfo> iter=sets.iterator();
		while(iter.hasNext()) {
			UserInfo s =iter.next();
			System.out.println(s.getName()+"/"+s.getAge());
		}
	}
}
/*
 * Q1.   다음 빈칸을 채우시오
1. 콜렉션프레임워크
- [ ##1. 배열  ]의 단점을 개선한 클래스 [##2.  객체   ]만 저장가능   ( 동적배열 )
- 저장공간의 크기를 [##3.  동적    ]으로 관리함.

2. 핵심 인터페이스 [##4. 3개  List / Set / Map   ]
- 인터페이스를 통해서 틀이 잡혀 있는 방법으로 
  다양한 컬렉션 클래스를 이용함.

  List : ##5.   기차      인덱스여부 [ O ] ,  중복허용여부 [ O ], 
  				[ add, get(index), size, remove, contains ] 
  Set  : ##6.   주머니   인덱스여부  [ X ] ,  중복허용여부  [ X ],
				[add, 향상된 for/Iterator, size, remove, contains ] 
  Map  : ##7.   사전 [ 키:값  ] - 쌍(Entry),        
  				[put, get(key), size, remove, contains ] 

Q2.  ArrayList, HashSet 을 작성하시오.
1. UserInfo    Dto 클래스만들기    - 속성 :  private  String name; private  int age;
2. users ArrayList 만들기
3. 다음의 데이터 넣기
   new UserInfo("아이언맨" , 50) , new UserInfo("헐크" , 40) , new UserInfo("캡틴" , 120)
4. for+size / 향상된 for 이용해서 데이터 출력
 

5. sets  HashSet 만들기
6. 다음의 데이터 넣기
   new UserInfo("아이언맨" , 50) , new UserInfo("헐크" , 40) , new UserInfo("캡틴" , 120)
7. for+size / 향상된 for 이용해서 데이터 출력*/
