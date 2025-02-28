package java_project001;

import java.util.Scanner;
import java.util.Arrays;
public class Id_input_test {

	public static void main(String[]args) {
		Scanner scanner = new Scanner(System.in);
		String[]id = new String[3];
		String[]psd = new String[3];
		int run=0;
		
		boolean r =true;
		System.out.println(Arrays.toString(id));
//		System.out.print("아이디 입력:");
//		id[0] = scanner.next();
//		System.out.print("비밀번호 입력:");
//		psd[0] = scanner.next();
		while(run!=3) {
			int cnt=0;
			System.out.print("1.추가 : ");
			run = scanner.nextInt();
			switch(run) {
			case 1:
				for(int i=0;i<3;i++) {if(id[i]==null&&cnt==0) {System.out.print("아이디 입력:");
				id[i] = scanner.next();System.out.println(Arrays.toString(id));run=2;cnt++;}}
			
				break;
				
			
				}
		}
		
	}
}		
			
		
//if (choice >= 2 && choice <= 5) {
//    System.out.print("아이디 입력: ");
//    inputid = scanner.next();
//    System.out.print("비밀번호 입력: ");
//   inputpsd = scanner.next();
//    for (int i = 0; i < id.length; i++) {
//        if (inputid.equals(id[i]) && inputpsd.equals(psd[i])) {
//            k = i;
//            break;
//        }
//    }
//    if (k == -1) {
//        System.out.println("아이디를 다시 확인해주세요");
//        choice = 0;
//        continue;
//    }
//}
	


