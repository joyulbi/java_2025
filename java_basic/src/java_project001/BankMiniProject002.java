package java_project001;

import java.util.Scanner;
//array추가
public class BankMiniProject002 {
	public static void main(String[]args) {
		Scanner scanner = new Scanner(System.in);
		String[]id = new String[3];
		String[]psd = new String[3];
		int[]age = new int[3];
		int[]bal = new int[3];
		String inputid = "";
		String inputpsd="";
		int bal2=0;
		int choice =0;
		
		while(choice!=9) {
			int cnt=0;
			System.out.println("\n=========BANK=========");
			System.out.println("1.추가");
			System.out.println("2.조회");
			System.out.println("3.입금");
			System.out.println("4.출금");
			System.out.println("5.삭제");
			System.out.println("9.종료");
			System.out.print("입력>>");
			//System.out.println(choice);
			choice = scanner.nextInt();	
			int k = -1;
			
			if(choice >= 2 && choice <= 5) {
				System.out.print("아이디 입력:"); inputid = scanner.next();
				System.out.print("비밀번호 입력:"); inputpsd = scanner.next();
				for(int i = 0; i < id.length; i++) {
					if(inputid.equals(id[i]) && inputpsd.equals(psd[i])) {
						k=i;
						break;
					}
				}
				if(k==-1) {
					System.out.println("아이디를 다시 확인해주세요");
					choice = 0;
				}
			}
			switch(choice){
			case 1: 
				int cnt2=0;
				for(int i=0;i<3;i++) {
					if(id[i]==null&&cnt==0) {
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

				break;
			case 2 : 
					System.out.println("\n\n<<<<<계좌조회>>>>>\n");
					System.out.println("ID : "+""+id[k]+"");
					System.out.println("PASSWORD : "+""+psd[k]+"");
					System.out.println("나이 : "+age[k]);
					System.out.println("잔액 : "+bal[k]);
					break;
			case 3:
					System.out.print("입금:");
					bal[k] += scanner.nextInt();
					break;
			case 4:
					System.out.print("출금:");
					bal2 = bal[k] - scanner.nextInt();
					if(bal2>=0) {bal[k]=bal2;}
					else {System.out.println("잔액이 부족합니다");}
					break;
			case 5:
					System.out.print("아이디를 삭제하시겠습니까? Y,N:");
					char cancel = scanner.next().charAt(0);
					if(cancel == 'Y'||cancel == 'y') {
						id[k] = null;
						psd[k]= null;
						System.out.println("계정삭제를 완료하였습니다.");
						cnt--;
					}else {System.out.println("계정삭제를 취소하셨습니다.");}
					break;
			}
		}
		System.out.println("종료하겠습니다");
	}
}		
			
		
	
	


