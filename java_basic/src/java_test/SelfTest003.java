package java_test;
import java.util.Scanner;
public class SelfTest003 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("국어점수를입력해주세요 > "); int kor= scanner.nextInt();
		System.out.print("영어점수를입력해주세요 > "); int eng= scanner.nextInt();
		if(kor<40) {System.out.println("국어과락");}
		if(eng<40) {System.out.println("영어과락");}
	}

}
