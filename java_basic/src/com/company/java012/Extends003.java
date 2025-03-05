package com.company.java012;
//1. 클래스는 부품객체
//2. 상태(멤버변수)와 행위(멤버함수)
/*3. 상속 - 재사용	오버라이드 - 부모 메서드 나한테 맞게 수정						
*   									MobileNote9 my9 = new MobileNote9();
*   Object {   }						
*   ↑									
*   MobileNote7	iris(private) 			
*   			void newshow(){}					
*   ↑									
*   MobileNote8	face(private) 			
*   			void newshow(){} 
*	↑
*	MobileNote9 battery(private) 
*				void newshow(){} 
*/
class MobileNote7 {
	private String iris;
	//public > protected > package(#) > private
	public String getIris() {return iris;}
	public void setIris(String iris) {this.iris = iris;}
	void newShow() {
		System.out.println("::::::NOTE7 새로운 기능(Overriding)");
		System.out.println("= iris : 홍채인식가능! "+"\n"+"= iris : "+this.iris);}
}

class MobileNote8 extends MobileNote7 {
	private String face;
	public void setFace(String face) {this.face = face;}
	@Override protected void newShow() {
		super.newShow(); //MobileNote7의 newShow()
		System.out.println("::::::NOTE8 새로운 기능(Overriding)");
		System.out.println("= face 안면인식 가능!"+"\n"+"= face : "+this.face);}
}
class MobileNote9 extends MobileNote8 {
	private int battery;
	public MobileNote9() {super();battery = 24;}
	public int getBattery() {return battery; }
	public void setBattery(int battery) {this.battery = battery;}
	//@Override void newShow1() {} Override 앞에쓰면 부모와 다른이름이면 안됨
	@Override public void newShow() { //MobileNote8의 newShow()
		super.newShow();
		System.out.println("::::::NOTE9 새로운 기능(Overriding)");
		System.out.println("= battery 하루종일 사용가능! "+"\n"+"= battery : "+this.battery);
	}
}
public class Extends003 {
	public static void main(String[] args) {
		MobileNote9 my9 = new MobileNote9();
		my9.setIris("brown");
		my9.setFace("pretty");
		my9.newShow();
	}

}
