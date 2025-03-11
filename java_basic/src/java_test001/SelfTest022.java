package java_test001;
//SelfTest021 메서드 오버로딩임

//오버라이딩
class milk{
	 public void milk() {
		System.out.println("우유");
	}
}
class milk_1 extends milk{
	@Override public void milk() {
		System.out.println("딸기우유");
	}

	
	
}

public class SelfTest022 {
	public static void main(String[] args) {
		milk milk = new milk();
		milk.milk();
		milk_1 milk_1 = new milk_1();
		milk_1.milk();
	}

}
//다른 클래스 하나를 상속받아서 같은 메서드