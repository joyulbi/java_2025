package com.company.java018;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class JavaIO002_byte {
	public static void main(String[] args) {
		//#1. 경로 준비
		String folder_fel="src/com/company/java018/";
		String file_rel="file002.txt";
		
		File folder = new File(folder_fel);
		File file = new File(folder_fel+file_rel);
		
		//#2. 폴더와 파일 만들기
		try {
			if(!folder.exists()) {folder.mkdir();}
			if(!file.exists()) {file.createNewFile();}
			System.out.println("폴더/파일 준비완료");
		}catch(Exception e) {e.printStackTrace();}
		
		
		//#3. byte 단위로 파일쓰기 InputStream > [프로그램] > OutputStream [#]
		//ctrl + shift + o
		try {
			OutputStream output=new FileOutputStream(file);
			output.write('j');
			output.write('a');
			output.write('v');
			output.write('a');
			output.flush();//비우는 기능
			output.close();//닫기 꼭 해주기
			System.out.println("OutputStream 쓰기 완료");
		} catch (Exception e) { e.printStackTrace(); }
		
		//#4. byte 단위로 파일읽기 InputStream[#] > [프로그램] > OutputStream 
		try {
			InputStream input=new FileInputStream(file);
			//System.out.println(input.read()); //문자는 저장시 숫자로 출력
			int cnt = 0;
			while((cnt=input.read())!=-1) { // -1 파일 끝날시 -1 return
				System.out.println((char)cnt);
			}
			input.close();
		} catch (Exception e) { e.printStackTrace(); }
	}
}
