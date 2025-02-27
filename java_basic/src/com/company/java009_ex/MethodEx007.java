package com.company.java009_ex;
import java.util.Scanner;
import java.util.Arrays;
public class MethodEx007 { 
	public static void who_are_you(String[][]users) {
		Scanner scanner = new Scanner(System.in);
		String result="";
		System.out.print("아이디를 입력하세요 > ");
		String id =scanner.next();
		for(int ch=0; ch<users.length; ch++) {
			if(id.equals(users[ch][0])) {
				System.out.println(users[ch][0]+" 님은 "+users[ch][2]+" 사람 입니다.");}}}
	
	public static void who_pass_change(String[][]users) {
		Scanner scanner = new Scanner(System.in);
		String changePsd="";
		
		int confirm=0;
		System.out.print("아이디를 입력하세요 > ");
		String id =scanner.next();
		System.out.print("비밀번호를 입력하세요 > ");
		String psd =scanner.next();
		for(int ch=0; ch<users.length; ch++) {
			if(id.equals(users[ch][0])&&psd.equals(users[ch][1])){
				System.out.print("변경할 비밀번호를 입력하세요 > ");
				changePsd =scanner.next();
				users[ch][1]=changePsd;
				confirm=1;
				for(int kan=0;kan<users[ch].length;kan++) {
					System.out.print(users[ch][kan]+" ");}}
		}System.out.println(confirm!=1?"유저를 확인해주세요":"");
	}
	////////////////////////////////////////////
	public static void main(String[] args) {
		String[][]users= {{"aaa","111","한국"},{"bbb","222","호주"},{"ccc","333","중국"}};
		who_are_you(users);
		who_pass_change(users);
	}
	///////////////////////////////////////////
}


