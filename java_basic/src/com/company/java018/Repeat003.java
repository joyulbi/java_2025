package com.company.java018;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

class Info{
	int no; String name; int age;
	public Info() { super();}
	public Info(int no, String name, int age) { super(); this.no = no; this.name = name; this.age = age; }
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
		Info other = (Info) obj;
		return age == other.age && Objects.equals(name, other.name) && no == other.no;
	}	
	
	
}

public class Repeat003 {
	public static void main(String[] args) {
		//ArrayList
		List<Info> list = new ArrayList<>();
		list.add(new Info(1,"iron",45));
		list.add(new Info(2,"hulk",38));
		list.add(new Info(3,"captain",120));
		System.out.println("======================\r\n"
				+ "NO	NAME	AGE\r\n"
				+ "======================");
		int result=0;
		Iterator <Info> iter = list.iterator();
		while(iter.hasNext()) {
			Info temp = iter.next();
			System.out.println(temp.no+"\t"+temp.name+"\t"+temp.age);
			result += temp.age;}
		System.out.println("나이총합 : "+result+"\n나이평균 : "+String.format("%.2f", (double)result/list.size()));
		System.out.println();
		
		//HashSet
		Set<Info> set = new HashSet<>();
		set.add(new Info(1,"iron",45));
		set.add(new Info(2,"hulk",38));
		set.add(new Info(3,"captain",120));
		set.add(new Info(3,"captain",120));
		set.remove(new Info(3,"captain",120));
		System.out.println("======================\r\n"
				+ "NO	NAME	AGE\r\n"
				+ "======================");
		int result2=0;
		Iterator <Info> iter2=set.iterator();
		while(iter2.hasNext()) {
			Info temp = iter2.next();
			System.out.println(temp.no+"\t"+temp.name+"\t"+temp.age);
			result2 += temp.age;}
		System.out.println("나이총합 : "+result2+"\n나이평균 : "+String.format("%.2f", (double)result/list.size()));
		System.out.println();
		
		//HashMap
		Map<Integer,Info> map = new HashMap<>();
		map.put(1, new Info(1,"iron",45));
		map.put(2, new Info(2,"hulk",38));
		map.put(3, new Info(3,"captain",120));
		map.put(4, new Info(3,"captain",120));
		map.remove(4);
		System.out.println(map.containsKey(1));
		
		System.out.println("======================\r\n"
				+ "NO	NAME	AGE\r\n"
				+ "======================");
		int result3=0;
		Iterator<Entry <Integer, Info>> eter= map.entrySet().iterator(); //entrySet키 값 둘다 주는거
		while(eter.hasNext()) {
			Info temp = eter.next().getValue();
			//Info key = temp.getValue();
			System.out.println(temp.no+"\t"+temp.name+"\t"+temp.age);
			result3 += temp.age; }
		System.out.println("나이총합 : "+result3+"\n나이평균 : "+String.format("%.2f", (double)result/list.size()));
	}

}
/*Q7.  ArrayList
 		 * 	 dto 를 이용하여 ArrayList + Iterator  이용해서 만들기  

Q8.   HashSet
		 *   dto 를 이용하여 HashSet   + Iterator  이용해서 만들기  

Q9.   HashMap
		 *   dto 를 이용하여 HashMap   + Iterator  이용해서 만들기  
		 
		 ㅁ 출력된결과
		 ======================
		 NO	NAME	AGE
		 ======================
		 1	iron		45
		 2	hulk		38
		 3	captain	120
		 
		 나이총합 : 203
		 나이평균 : 67.67*/