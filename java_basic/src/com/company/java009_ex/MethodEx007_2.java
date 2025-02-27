//선생님 방식
package com.company.java009_ex;

import java.util.Arrays;
import java.util.Scanner;

public class MethodEx007_2 {
	public static void  who_are_you(String [][] users){  //아이디를입력받아서 나라조회 
		//변수
		String id=""; String result="";
		Scanner scanner = new Scanner(System.in);
		//입력
		System.out.print("아이디를 입력해주세요>");   id=scanner.next();
		//처리 
		//if( 입력받은 id가   "aaa" 같니) { aaa는 한국사람입니다. }
		//if( 입력받은 id가   "bbb" 같니) {  bbb 호주사람입니다. }
		//if( 입력받은 id가   "ccc" 같니) {  중국 호주사람입니다. }   
		
		//if( id.equals(users[0][0])) { users[0][0]+"는"+  users[0][2]+"사람입니다." }
		//if( id.equals(users[1][0])){ users[1][0]+"는"+  users[1][2]+"사람입니다." }
		//if( id.equals(users[2][0])){ users[2][0]+"는"+  users[2][2]+"사람입니다." }
		
		for(int ch=0; ch<users.length; ch++) {
			if( id.equals(users[ch][0])) { result= users[ch][0]+"는 "+  users[ch][2]+"사람입니다. "; }
		}
		//출력
		System.out.println( result );
	}
	public static void who_pass_change(String [][] users ){  //아이디,비밀번호가 맞으면 비밀번호 바꾸기
		//변수
		String temp_id="" , temp_pass="";  String result ="유저를 확인해주세요"; 
		Scanner scanner = new Scanner(System.in);  
		
		//입력
		System.out.print("아이디를 입력해 주세요 > ");   temp_id=scanner.next();
		System.out.print("비밀번호를 입력해 주세요 > ");  temp_pass=scanner.next();
		
		//처리 
		// 1) 사용자 인증1 - if(입력받은 아이디와 "aaa" / 입력받은 비번과 111같다면) { 해당유저의  0층 }
		//			    - if(입력받은 아이디와 "bbb" / 입력받은 비번과 222같다면) { 해당유저의  1층 }
		//    사용자 인증2 - if(temp_id.equals(users[0][0])  && temp_pass.equals(users[0][1]) ) {  0층 }
		//			    -  if(temp_id.equals(users[1][0])  && temp_pass.equals(users[1][1]) ) {  1층 }
		// 2) 맞다면 새로운비번입력  - 변경하실 비밀번호를 입력해주세요123
		int find=-1;
		for(int ch=0; ch<users.length; ch++){ 
		   if(temp_id.equals(users[ch][0])  && temp_pass.equals(users[ch][1]) ) { find=ch; break; }    
		}
		if(find != -1) {
			System.out.print("변경하실 비밀번호를 입력해주세요 > ");
			users[find][1] = scanner.next();     result = Arrays.toString(users[find]);
		}
		//출력
		System.out.println(result);
	}
	public static void main(String[] args) {
		// 변수
		String [][] users = {{ "aaa"  , "111"   , "한국"     } ,     // 00 01 02
							 { "bbb" , "222"   , "호주"       } ,    // 10 11 12
							 { "ccc"  , "333"   , "중국"      }};    // 20 21 22
		// 입력
		//  who_are_you(users);  
		//  public static 리턴값  메서드명(파라미터){ 해야할일  }
		//  public static void  who_are_you(String [][] users){  아이디를입력받아서 나라조회 }
		
		
		who_pass_change(users); 
		//  public static 리턴값  메서드명(파라미터){ 해야할일  }
		//  public static void who_pass_change(String [][] users ){ 아이디,비밀번호가 맞으면 비밀번호 바꾸기}
		
	}
	/////////////////////////////////////

	
}