package com.company.java004_ex;

import java.util.Scanner;

public class Methodtest {
	public static void main(String[] args) {
		Methodtest m = new Methodtest();
		m.bank();
       }
       public void bank() {
    	   boolean run = true;
    	   int balance = 0;
    	   Scanner scanner = new Scanner(System.in);
    	   while(run) {
    		   System.out.println("----------------------------");
    		   System.out.println("1.예금");
    		   System.out.println("2.출금");
    		   System.out.println("3.잔고");
    		   System.out.println("4.종료");
    		   System.out.print("선택> ");
    		   int num = scanner.nextInt();
    		   switch(num) {
    		   case 1:
    			   System.out.print("예금액> ");
    			   balance += scanner.nextInt();
    			   break;
    			case 2:
    				System.out.print("출금액> ");
    				balance -= scanner.nextInt();
    				break;
    			case 3:
    				System.out.println(String.format("잔고> %d",balance));
    				break;
    			case 4:
    				run = false;
    				break;
    			default:
    				System.out.println("알수없는 입력입니다.");
                      }
               }
               System.out.println("프로그램 종료");
       }
}
