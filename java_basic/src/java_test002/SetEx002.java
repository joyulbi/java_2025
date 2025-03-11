package java_test002;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

class UserInfo2{
	private int no; private  String name; private  int age;

	public UserInfo2() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserInfo2(int no, String name, int age) {
		super();
		this.no = no;
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "UserInfo [no=" + no + ", name=" + name + ", age=" + age + "]";
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, name, no);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserInfo2 other = (UserInfo2) obj;
		return age == other.age && Objects.equals(name, other.name) && no == other.no;
	}
	
	
}

public class SetEx002 {
	public static void main(String[] args) {
		Set<UserInfo2> users = new HashSet<>();
		users.add(new UserInfo2(1, "아이언맨" , 50));
		users.add(new UserInfo2(2, "헐크" , 40));
		users.add(new UserInfo2(3, "캡틴" , 120));
		users.add(new UserInfo2(3, "캡틴" , 120));
		
		//향상된 for
		for(UserInfo2 e:users) {System.out.println(e.getAge()+"/"+e.getName()+"/"+e.getNo());}
		System.out.println(users.size());
		System.out.println("=======================================");
		
		Scanner  scanner = new Scanner(System.in);
		System.out.print("원하는 유저의 정보입력 > ");
		String name = scanner.next(); 
		
		//Interator
		Iterator <UserInfo2> iter=users.iterator();
		while(iter.hasNext()) {
			UserInfo2 s = iter.next();
			if(name.equals(s.getName())) {System.out.println(s.getAge()+"/"+s.getName()+"/"+s.getNo());}}
			
		
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