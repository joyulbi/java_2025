package com.company.java011;
import com.company.java011_ex.Cat;

public class Modifier1_public {
	public static void main(String[] args) {
		Cat cat = new Cat();
		cat.public_=10;
		//cat.protected_=20;안보임
		//cat.package_안보임
		//cat.private_안보임
		cat.setPrivate_(100);
		System.out.println(cat.public_+"/"+cat.getPrivate_());
		//private은 getter + setter를 이용
	}
}
