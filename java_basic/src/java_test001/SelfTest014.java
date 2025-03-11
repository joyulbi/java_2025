package java_test001;
import java.util.Scanner;
public class SelfTest014 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int result = 0;
		for(int num =2;num<=4;num++) {
			System.out.println(num+"단");
			for(int i = 1; i<=9; i++) {
				result = num*i;
				System.out.println(num+"*"+i+"="+result);
			}
		}
		
	}
}
