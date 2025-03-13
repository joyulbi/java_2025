package com.company.java018;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class JavaIO005_buffered {
	public static void main(String[] args) {
		//#1. 경로 준비
		String folder_fel="src/com/company/java018/";
		String file_rel="file004.txt";
		
		File folder = new File(folder_fel);
		File file = new File(folder_fel+file_rel);
		
		//#2. 폴더와 파일 만들기
		try {
			if(!folder.exists()) {folder.mkdir();}
			if(!file.exists()) {file.createNewFile();}
			System.out.println("폴더/파일 준비완료");
		}catch(Exception e) {e.printStackTrace();}
		
		//#3. byte 단위로 파일쓰기 InputStream > [프로그램] > OutputStream [#]
		//BufferedWriter(속도향상) -  OutputStreamWriter(단어) - OutputStream(byte)
		try {
			BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
			bw.write("1,white,1200\n");
			bw.write("2,choco,1500\n");
			bw.write("3,banana,1800\n");
			bw.flush(); bw.close();
			System.out.println(">>쓰기 완료!");
		} catch (Exception e) {  e.printStackTrace(); }
		
		//#4. byte 단위로 파일읽기 InputStream[#] > [프로그램] > OutputStream 
		//BufferedReader(속도향상) -  InputStreamReader(단어) - InputStream(byte)
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			//System.out.println(br.readLine());
			String line="";
			StringBuffer sb = new StringBuffer();
			while((line=br.readLine())!=null) {//cnt - char로 하면안되는지 ==> Buffered는 하나하나가 아니라 한꺼번에 불러옴
				System.out.print(line+"\n");
			}
			System.out.println(sb.toString());//왜 사용하는지
			br.close();
		} catch (Exception e) {  e.printStackTrace(); }
	}
}
