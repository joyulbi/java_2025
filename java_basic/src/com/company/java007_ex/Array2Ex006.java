package com.company.java007_ex;
//////다시확인하기
public class Array2Ex006 {
	public static void main(String[] args) {
		int[][] datas = {{10, 10, 10 ,10}, 
	         {20, 20, 20 ,20}, 
	         {30, 30, 30 ,30}};
		int total=0;
		int[][] result = new int[datas.length+1][datas[0].length+1];
		for(int ch=0; ch< datas.length; ch++) { //#1 층의 정보  ch<3
			for(int kan=0; kan<datas[ch].length; kan++) { //#2 칸의 정보  kan<4
				result[ch][kan] = datas[ch][kan];   //todo1. 데이터 복사해서 넣기
				result[ch][datas[ch].length] += result[ch][kan];  //todo2. 가로방향데이터 더하기
				result[datas.length][kan] += result[ch][kan]; //todo3. 세로방향데이터 datas.length  - 3  
				result[datas.length][datas[ch].length] += datas[ch][kan];// todo4. 총합
			}
		}// end 
		
		for(int ch=0; ch<result.length; ch++) { //#1 층의 정보
			for(int kan=0; kan<result[ch].length; kan++) { //#2 칸의 정보
				System.out.print( result[ch][kan]  +"\t");
			}// end ch
			//#3. 한층이 끝나고 나면 해야할일
			System.out.println();
		}// end ch
	}
}