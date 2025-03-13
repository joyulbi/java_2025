package java_project002;
import java.util.Scanner;

class Add {
	static int cnt;
	static String[]id = new String[3];
	static String[]psd = new String[3];
	static int[]age = new int[3];
	static int[]bal = new int[3];
	static void add() {
		cnt=0;
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
		System.out.println(BankMiniProject003.k);
		System.out.println("\n\n<<<<<계좌조회>>>>>\n");
		System.out.println("ID : "+""+Add.id[BankMiniProject003.k]+"");
		System.out.println("PASSWORD : "+""+Add.psd[BankMiniProject003.k]+"");
		System.out.println("나이 : "+Add.age[BankMiniProject003.k]);
		System.out.println("잔액 : "+Add.bal[BankMiniProject003.k]);
	}
}

class Input{
	static void Input() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("입금:");
		Add.bal[BankMiniProject003.k] += scanner.nextInt();
		
	}
}
class Output{
	static void Output() {
		int bal2=0;
		Scanner scanner = new Scanner(System.in);
		System.out.print("출금:");
		bal2 = Add.bal[BankMiniProject003.k] - scanner.nextInt();
		if(bal2>=0) {Add.bal[BankMiniProject003.k]=bal2;}
		else {System.out.println("잔액이 부족합니다");}
	}
}
class Delete{
	static void Delete() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("아이디를 삭제하시겠습니까? Y,N:");
		char cancel = scanner.next().charAt(0);
		if(cancel == 'Y'||cancel == 'y') {
			Add.id[BankMiniProject003.k] = null;
			Add.psd[BankMiniProject003.k]= null;
			System.out.println("계정삭제를 완료하였습니다.");
			Add.cnt--;
		}else {System.out.println("계정삭제를 취소하셨습니다.");}
	}	
}
