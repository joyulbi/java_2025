package java_test;
import java.util.Scanner;
public class SelfTest013 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int result = 0;
		System.out.print("원하는 단을 입력하세요 > "); int num=scanner.nextInt();
		for(int i = 1; i<=9; i++) {
			result = num*i;
			System.out.println(num+"*"+i+"="+result);
		}
	}
}
