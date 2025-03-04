package java_test;
//SelfTest021 메서드 오버로딩임

//오버라이딩
class milk{
	static void milk() {
		System.out.println("우유");
	}
}
class milk_1 extends milk{
	static void milk() {
		System.out.println("딸기우유");
	}

	
	
}

public class SelfTest022 {
	public static void main(String[] args) {
		milk.milk();
		milk_1.milk();
	}

}
