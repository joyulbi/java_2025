package com.company.java018;

import java.io.File;

public class Repeat004 {
	public static void main(String[] args) {
		//#1. 경로
		String folder_rel="src/com/company/java018/";
		String file_rel="JavaIO002.txt";
		
		File folder = new File(folder_rel);
		File file = new File(folder_rel+file_rel);
		
		//#2. 폴더와 파일 만들기
		try{
			if(!folder.exists()) {folder.mkdir();}
			if(!file.exists()) {file.createNewFile();}
			System.out.println("폴더/파일 준비완료");
		}catch(Exception e){e.printStackTrace();}
	}

}
/*Q10.  다음과 같이 폴더와 파일을 만들어주세요!
	1. folder 만들기   - 금일 패키지  com.company.java018
	2. 파일만들기      - 위의폴더에   JavaIO002.txt*/