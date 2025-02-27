package java_project;

import java.util.Scanner;

public class BankMiniProject002 {
	public static void add() {}
	public static void main(String[]args) {
		Scanner scanner = new Scanner(System.in);
		String[]id = new String[3];
		String[]psd = new String[3];
		//String id= "";
		//String psd="";
		String inputid = "";
		String inputpsd="";
		int age = 0;
		int bal = 0;
		int bal2=0;
		int choice =0;
		while(choice!=9) {
			System.out.println("\n=========BANK=========");
			System.out.println("1.추가");
			System.out.println("2.조회");
			System.out.println("3.입금");
			System.out.println("4.출금");
			System.out.println("5.삭제");
			System.out.println("9.종료");
			System.out.print("입력>>");
			choice = scanner.nextInt();	
			switch(choice){
			case 2:case 3:case 4:case 5:
				System.out.print("아이디 입력:");
				inputid = scanner.next();
				System.out.print("비밀번호 입력:");
				inputpsd = scanner.next();
				if(!(inputid.equals(id) && inputpsd.equals(psd))) {
					System.out.println("아이디를 다시확인해주세요");choice = 0;}
				break;}
			switch(choice){
			case 1: 
				System.out.print("아이디 입력:");
				id[0] = scanner.next();
				System.out.print("비밀번호 입력:");
				psd[0] = scanner.next();
				System.out.print("나이 입력:");
				age = scanner.nextInt();
				System.out.print("잔액 입력:");
				bal = scanner.nextInt();
				break;
			case 2 : 
					System.out.println("\n\n<<<<<계좌조회>>>>>\n");
					System.out.println("ID : "+""+id+"");
					System.out.println("PASSWORD : "+""+psd+"");
					System.out.println("나이 : "+age);
					System.out.println("잔액 : "+bal);
					break;
			case 3:
					System.out.print("입금:");
					bal += scanner.nextInt();
					break;
			case 4:
					System.out.print("출금:");
					bal2 = bal - scanner.nextInt();
					if(bal2>=0) {bal=bal2;}
					else {System.out.println("잔액이 부족합니다");}
					break;
			case 5:
					System.out.print("아이디를 삭제하시겠습니까? Y,N:");
					char cancel = scanner.next().charAt(0);
					if(cancel == 'Y'||cancel == 'y') {
						id[0] = "";
						psd[0]= "";
						System.out.println("계정삭제를 완료하였습니다.");
					}else {System.out.println("계정삭제를 취소하셨습니다.");}
					break;
			}
		}
		System.out.println("종료하겠습니다");
	}
}		
			
		
	
	


