package java_project002;
import java.util.Scanner;

class Add {
	static int cnt;
	static String[]id = new String[3];
	static String[]psd = new String[3];
	static int[]age = new int[3];
	static int[]bal = new int[3];
	static void add() {
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < 3; i++) {
			if (id[i] == null && cnt == 0) {
				System.out.print("아이디 입력:");
				id[i] = scanner.next();
				System.out.print("비밀번호 입력:");
				psd[i] = scanner.next();
				System.out.print("나이 입력:");
				age[i] = scanner.nextInt();
				System.out.print("잔액 입력:");
				bal[i] = scanner.nextInt();
				cnt++;
			}
		}
	}
}
class Check{
	static void check() {
		System.out.println("\n\n<<<<<계좌조회>>>>>\n");
		System.out.println("ID : "+""+Add.id[BankMiniProject003.k]+"");
		System.out.println("PASSWORD : "+""+Add.psd[BankMiniProject003.k]+"");
		System.out.println("나이 : "+Add.age[BankMiniProject003.k]);
		System.out.println("잔액 : "+Add.bal[BankMiniProject003.k]);
	}
}
//public class Case{}