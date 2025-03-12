package com.company.java017;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

class Milk {
	private int no; private String name; private int price;
	public Milk() { super(); }
	public Milk(int no, String name, int price) { super(); this.no = no; this.name = name; this.price = price; }
	@Override public String toString() { return "Milk [no=" + no + ", name=" + name + ", price=" + price + "]"; }
	public int getNo() { return no; }  public void setNo(int no) { this.no = no; }
	public String getName() { return name; }  public void setName(String name) { this.name = name; }
	public int getPrice() { return price; }  public void setPrice(int price) { this.price = price; }
	@Override
	public int hashCode() {
		return Objects.hash(name, no, price);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Milk other = (Milk) obj;
		return Objects.equals(name, other.name) && no == other.no && price == other.price;
	}	
	
}

public class Repeat001 {
	public static void main(String[] args) {
		List<Milk> milk = new ArrayList<>();
		milk.add(new Milk(1,"white",1000));
		milk.add(new Milk(2,"choco",1200));
		milk.add(new Milk(3,"banana",1300));
		milk.add(new Milk(3,"banana",1300));
		System.out.println("===============================\n<ArrayList>\nNO\tNAME\tPRICE\n===============================");
		for(Milk temp:milk) {
			System.out.println(temp.getNo()+"\t"+temp.getName()+"\t"+temp.getPrice());
		}
		
		System.out.println("\n===============================\n<HashSet>\nNO\tNAME\tPRICE\n===============================");
		Set<Milk> milk1 = new HashSet<>();
		milk1.add(new Milk(1,"white",1000));
		milk1.add(new Milk(2,"choco",1200));
		milk1.add(new Milk(3,"banana",1300));
		milk1.add(new Milk(3,"banana",1300));
		for(Milk temp:milk1) {
			System.out.println(temp.getNo()+"/"+temp.getName()+"/"+temp.getPrice());
		}
		
		System.out.println("\n===============================\n<HashMap>\nNO\tNAME\tPRICE\n===============================");
		Map<Integer,Milk> milk2 = new HashMap<>();
		milk2.put(5,new Milk(1,"white",1000));
		milk2.put(6,new Milk(2,"choco",1200));
		milk2.put(7,new Milk(3,"banana",1300));
		milk2.put(7,new Milk(3,"banana",1300));
		milk2.put(9, null);
		milk2.remove(9);
		System.out.println(milk2.get(1));
		System.out.println(milk2.size());
		System.out.println("1있는지 "+milk2.containsKey(1)+"\n");
		
		
		
		Iterator<Integer> iter= milk2.keySet().iterator();
		while(iter.hasNext()) {
			int key = iter.next();
			System.out.println(key+"/"+milk2.get(key));
		}
		System.out.println();
		Iterator <Entry <Integer, Milk>> eter= milk2.entrySet().iterator();
		while(eter.hasNext()){
			Entry <Integer, Milk> entry = eter.next();
			Milk temp = entry.getValue();
		//	System.out.println(entry.getKey()+"....."+entry.getValue() + " ....." +milk2.get(entry.getKey()));
			System.out.println(temp.getNo()+"\t"+temp.getName()+"\t"+temp.getPrice());
		}
	}

}