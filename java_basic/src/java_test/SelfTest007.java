package java_test;
import java.util.Scanner;
public class SelfTest007 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("a,b,c중에 입력해주세요 > "); char ch= scanner.next().charAt(0);
		switch(ch) {
		case 65:case 97:System.out.println("apple"); break;
		case 66:case 98:System.out.println("banana"); break;
		case 67:case 99:System.out.println("coconut"); break;
		default:System.out.println("대소문자 관계없이 a,b,c만 입력가능합니다."); break;
		}
	}

}
