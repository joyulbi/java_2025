package java_test001;

public class SelfTest021 {
	 static void print(int a,int b) {
		System.out.println(a+b);
	}
	 static void print(double a,double b) {
		 System.out.println(a+b);
	}
	 public static void main(String[] args) {
		print(3,5);
		print(1.2,3.4);
	}
}
