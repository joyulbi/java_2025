package com.company.java011;

import java.util.Arrays;


//class A{//The type A is already defined
class A1{
	String name;
	
	@Override
	public String toString() {
		return name;
		//return "A1 [name=" + name + "]";
	}

}

public class ClassArr001 {
	public static void main(String[] args) {
		//int [] arr= new int[3];  비교
		A1[] carr=new A1[3];
		System.out.println(Arrays.toString(carr));
		System.out.println("개수 > "+carr.length); // 개수 3 : index - 0~2
		//carr[0].name="apple"; System.out.println(carr[0]);
		
		carr[0] = new A1();//1) new 메빌,객체생성 2)A1()초기화 3) carr[0] 번지
		carr[0].name="apple"; System.out.println(carr[0].name);
		
		carr[1] = new A1();//1) new 메빌,객체생성 2)A1()초기화 3) carr[1] 번지
		carr[1].name="banana"; System.out.println(carr[1].name);
		
		carr[2] = new A1();//1) new 메빌,객체생성 2)A1()초기화 3) carr[2] 번지
		carr[2].name="coconut"; System.out.println(carr[2].name);
		
		System.out.println(Arrays.toString(carr));

	}
}
