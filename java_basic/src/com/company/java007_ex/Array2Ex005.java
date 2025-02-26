package com.company.java007_ex;

public class Array2Ex005 {
	public static void main(String[] args) {
		 int[][] arr = {
			{ 1, 1, 1,5},   // 00 01 02 
			{ 2, 2, 2},   // 10 11 12 
			{ 3, 3, 3},   // 20 21 22 
			{ 4, 4, 4},   // 30 31 32 
		 };
		 int total=0;  double avg=0.0;
 // ver-1                ver-2				ver-3 0층만계산
 // 총점에 00의 데이터 누적   total+=arr[0][0];
 // 총점에 01의 데이터 누적   total+=arr[0][1];
 // 총점에 02의 데이터 누적   total+=arr[0][2]; for(int kan=0;kan<arr[0].length;kan++){total+=arr[0][kan];}   //3
// ver-4 각층계산
//		 for(int kan=0;kan<arr[0].length;kan++){total+=arr[0][kan];}  //0층
//		 for(int kan=0;kan<arr[1].length;kan++){total+=arr[1][kan];}  //1층
//		 for(int kan=0;kan<arr[2].length;kan++){total+=arr[2][kan];}  //2층
//		 for(int kan=0;kan<arr[3].length;kan++){total+=arr[3][kan];}  //3층
		 
		for (int ch = 0; ch < arr.length; ch++) { //#1 층의정보
			for (int kan = 0; kan < arr[ch].length; kan++) {  //#2 칸의정보
				total += arr[ch][kan];
			}
			//#3. 한층이 끝날때 처리해야할일
			System.out.println(arr[ch].length);
		}                      // 층 * 칸
		avg =  (double)total/(arr.length * arr[0].length);    // 평균 = total/갯수(층갯수*칸갯수)
		
		 System.out.println("총점 : " + total);
		 System.out.println("평균 : " + avg);
	}
}
