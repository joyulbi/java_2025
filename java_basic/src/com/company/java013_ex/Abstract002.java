package com.company.java013_ex;
/*
Shape002{showArea(int w, int h); showArea(int r);}
	  ↑		       ↑		 ↑
 Rectangle002 Triangle002 Circle002
*/

abstract class Shape002{
	abstract void showArea(int w, int h);
	abstract void showArea(int r);// 설계 메서드
}
class Rectangle002 extends Shape002{
	@Override void showArea(int w, int h) { System.out.println("사각형의 넓이 :"+w*h);  }
	@Override void showArea(int r) {   } //불필요한 @Override
}
class Triangle002 extends Shape002{
	@Override void showArea(int w, int h) { System.out.println("삼각형의 넓이 :"+w*h/2);  }
	@Override void showArea(int r) {   } //불필요한 @Override
}
class Circle002 extends Shape002{
	@Override void showArea(int w, int h) {   } //불필요한 @Override
	@Override void showArea(int r) { System.out.println("원의 넓이 :"+String.format("%.2f",r*r*3.141592));  } 
}
public class Abstract002 {
	public static void main(String[] args) {
		////ver-1
		Shape002 shape = null;
		
		shape = new Rectangle002();
		shape.showArea(10,3);
		
		shape = new Triangle002();
		shape.showArea(10,10);
		
		shape = new Circle002();
		shape.showArea(10);
		System.out.println("=================================");
		////ver-2
		Shape002 shape2 = null;
		Shape002[] s = {new Rectangle002(),new Circle002(),new Triangle002()};
		//Circle이니? shape2.showArea(10);
		//instanceof - 객첵 어떤 클래스인지 어떤클래스를 상속 받았는지 확인
		if(s[0] instanceof Circle002) {s[0].showArea(10);}
		else {s[0].showArea(10,3);}
		
		if(s[1] instanceof Circle002) {s[1].showArea(10);}
		else {s[1].showArea(10,3);}
		
		if(s[2] instanceof Circle002) {s[2].showArea(10);}
		else {s[2].showArea(10,3);}
		
		System.out.println("=================================");
		
		for(int i=0;i<s.length;i++){
			if(s[i] instanceof Circle002){s[i].showArea(10);}
			else {s[i].showArea(10,3);}
		}
	}

}
