package java_project;
import java.util.Scanner;

import com.sun.tools.javac.Main;
public class AirplaneProject {
	public static void main(String[]args) {

		Scanner scanner = new Scanner(System.in);
		int choice =0;
		int choice1 =0;
		for(;choice!=9;) {
			System.out.println(" * KOREAN AIR * ");
			System.out.println("==============================================================");
			System.out.println("1. 로그인"+"\t"+"\t"+"2. 회원가입"+"\t"+"3. 회원탈퇴"+"\t"+"9. 종료"+"\t");
			System.out.println("==============================================================");
			System.out.print("입력 > ");
			choice = scanner.nextInt();
			int co = 1;
			System.out.print("아이디 입력 : ");
			char id = scanner.next().charAt(0);
			System.out.print("비밀번호 입력 : ");
			char psd = scanner.next().charAt(0);
			for(;co==1&&choice1 !=5;) {
				System.out.println("==============================================================");
				System.out.println("1. 항공권 예약"+"\t"+"2. 항공권 조회"+"\t"+"3. 항공권 취소"+"\t"+"4. 좌석변경"+"\t"+"5. 로그아웃");
				System.out.println("==============================================================");
				System.out.print("입력 > ");
				choice1 = scanner.nextInt();
				switch(choice1) {
				case 1:
					System.out.println("* 항공권 예약");
					System.out.print("도착지 입력 : ");
					char destination = scanner.next().charAt(0);
					System.out.print("출발지 입력 : ");
					char origin = scanner.next().charAt(0);
					System.out.print("가는날 : ");
					int go = scanner.nextInt();
					System.out.print("오는날 : ");
					int back = scanner.nextInt();
					System.out.println(destination+origin+go+back);
					break;
				case 2 :
					System.out.println("* 항공권 조회");
					break;
				case 3 :
					System.out.println("* 항공권 취소");
					break;
				case 4 :
					System.out.println("* 좌석변경");
					break;
				case 5 :
					System.out.println("* 로그아웃");	
					break;
				
			}

		}
		
	}
}}
