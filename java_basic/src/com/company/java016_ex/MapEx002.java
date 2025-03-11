package com.company.java016_ex;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

class UserInfo{
	private String name;
	private int num;
	public UserInfo() { super(); }
	public UserInfo(String name, int num) { super(); this.name = name; this.num = num; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public int getNum() { return num; }
	public void setNum(int num) { this.num = num; }
	@Override public String toString() { return "UserInfo [name=" + name + ", num=" + num + "]"; }
	
}
public class MapEx002 {
	public static void main(String[] args) {
		Map<  Integer,UserInfo> map  =new HashMap<>();
		map.put(  1,  new UserInfo("아이언맨", 50) );  // 1 넣어도 Integer( 클래스, 객체 )
		map.put(  2,  new UserInfo("헐크", 40) );  // wrapper 클래스
		map.put(  3,  new UserInfo("캡틴", 120) ); // boxing
		map.put(  1,  new UserInfo("아이언맨-new", 50) ); 
		
		
//		int      a=1;
//		Integer  b=2; // box
//		System.out.println(a + "/" +b.byteValue());
		
		
		Iterator <Entry <Integer, UserInfo>> eter = map.entrySet().iterator();
		while(eter.hasNext()){
			 Entry <Integer, UserInfo> temp =eter.next();
			 System.out.println(temp.getKey()+""+temp.getValue());
		}

	}
}
