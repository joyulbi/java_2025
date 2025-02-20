package com.company.java004_ex;

import java.util.Scanner;

public class Bank_mini_project {
	public static void main(String[]args) {
		Bank_mini_project b = new Bank_mini_project();
		b.bank();}
	public void bank() {
		Scanner scanner = new Scanner(System.in);
		char id= 0;
		char psd=0;
		int age = 0;
		int bal = 0;
		boolean run= true;
		while(run) {
			System.out.println("=========BANK=========");
			System.out.println("1.추가");
			System.out.println("2.조회");
			System.out.println("3.입금");
			System.out.println("4.출금");
			System.out.println("5.삭제");
			System.out.println("9.종료");
			System.out.print("입력>>");
			int choice = scanner.nextInt();
			
			switch(choice){
			case 1: 
				System.out.print("아이디 입력:");
				id = scanner.next().charAt(0);
				System.out.print("비밀번호 입력:");
				psd = scanner.next().charAt(0);
				System.out.print("나이 입력:");
				age = scanner.nextInt();
				System.out.print("잔액 입력:");
				bal = scanner.nextInt();
				break;
			case 2 : 
				System.out.print("아이디 입력:");
				char inputid = scanner.next().charAt(0);
				System.out.print("비밀번호 입력:");
				char inputpsd = scanner.next().charAt(0);
				int remeberpsd = (int)inputpsd;
				if((int)inputid==(int)id && (int)inputpsd==(int)psd) {
					System.out.println("<<<<<계좌조회>>>>>");
					System.out.println("ID : "+""+id+"");
					System.out.println("PASSWORD : "+""+psd+"");
					System.out.println("나이 : "+age);
					System.out.println("잔액 : "+bal);
				}else if((int)inputid!=(int)id || (int)inputpsd!=(int)psd) {
					System.out.println("다시확인해주세요");
				}
				break;
			case 3:
				System.out.print("아이디 입력:");
				inputid = scanner.next().charAt(0);
				System.out.print("비밀번호 입력:");
				inputpsd = scanner.next().charAt(0);
				remeberpsd = (int)inputpsd;
				if((int)inputid==(int)id && (int)inputpsd==(int)psd) {}
				 
			}
			
		}
		
	}
		
			
		
	
	

}
