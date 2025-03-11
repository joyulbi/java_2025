package java_test001;
import java.util.Scanner;
public class SelfTest005 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("당신의 이름을 입력해주세요 > "); int age= scanner.nextInt();
		if(age<19) {System.out.println("당신은 미성년자 입니다.");}
		else {System.out.println("당신은 성인 입니다.");}
		
	}

}
