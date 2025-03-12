package java_test002;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test009 {
	
	public static int nextInt() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("1입력> ");
		
		return scanner.nextInt();
		
	}
	public static void main(String[] args) {
		int one = 0;
		while(true) {
			try {one= nextInt(); 
			if(one==1) {break;}}
			catch(InputMismatchException e) {System.out.println("숫자입력!");}
		}
	}
}
