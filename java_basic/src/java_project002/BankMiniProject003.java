package java_project002;
import java.util.Scanner;

public class BankMiniProject003 {
//	public static int choice ;
	static int k = -1;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int choice=0 ;
		String inputid = "";
		String inputpsd="";
		while (choice != 9) {
			try {
				int cnt = 0;
				System.out.println("\n=========BANK=========");
				System.out.println("1.추가");
				System.out.println("2.조회");
				System.out.println("3.입금");
				System.out.println("4.출금");
				System.out.println("5.삭제");
				System.out.println("9.종료");
				System.out.print("입력>>");
				System.out.println(choice);
				choice = scanner.nextInt();
			}catch(Exception e) {
				scanner.next();
				System.out.println("잘못입력");}
			
			
			
			if(choice >= 2 && choice <= 5) {
				System.out.print("아이디 입력:"); inputid = scanner.next();
				System.out.print("비밀번호 입력:"); inputpsd = scanner.next();
				for(int i = 0; i < Add.id.length; i++) {
					if(inputid.equals(Add.id[i]) && inputpsd.equals(Add.psd[i])) {
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
			case 1:Add.add();break;
			case 2:Check.check(); break;
			case 3:Input.Input(); break;
			case 4:Output.Output(); break;
			case 5:Delete.Delete(); break;
			}
			
		}
	}

}
