package java_test001;
import java.util.Scanner;
public class SelfTest011 {	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int i = 0;
		while(i<1 || i>100) {
			System.out.print("숫자를 입력하세요 > "); i = scanner.nextInt();
		}
	}
}
