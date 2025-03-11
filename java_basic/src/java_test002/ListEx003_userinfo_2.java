package java_test002;

import java.util.ArrayList;
import java.util.Scanner;

class UserInfo{
	private String name; private int age;

	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserInfo(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "UserInfo [name=" + name + ", age=" + age + "]";
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
	
}

public class ListEx003_userinfo_2 {
	public static void main(String[] args) {
		ArrayList<UserInfo> users = new ArrayList<>();
		users.add(new UserInfo("아이언맨" , 50));
		users.add(new UserInfo("헐크" , 40));
		users.add(new UserInfo("캡틴" , 120));
		
		for(int i =0;i<users.size();i++) {System.out.println(users.get(i));}
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("입력: ");
		String str = scanner.next();
		
		for(UserInfo temp:users) {
			if(str.equals(temp.getName())) {System.out.println(temp.getName()+temp.getAge());}
			
		}
	}
}

/*

연습문제3)  Collection  Framework
패키지명 : com.company.java015_ex
클래스명 : ListEx003
1. UserInfo    Dto 클래스만들기    - 속성 :  private  String name; private  int age;
2. users ArrayList 만들기
3. 다음의 데이터 넣기
   new UserInfo("아이언맨" , 50) , new UserInfo("헐크" , 40) , new UserInfo("캡틴" , 120)
4. for+size / 향상된 for 이용해서 데이터 출력
5. 사용자들의 이름 입력받기 - 이름을 입력받으면 해당하는  유저의 자료출력

> 원하는 유저의 이름을 입력하세요    _예) 아이언맨
"아이언맨" , 50

*/