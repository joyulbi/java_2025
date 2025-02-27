package com.company.java009;
import java.util.Scanner;
public class Repeat {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//복습문제 1
		System.out.println("=========Q1===========");
		System.out.print("문자 하나를 입력하시오. >");
		char ch =scanner.next().charAt(0);
		if(ch=='j') {System.out.println("java");}
		else if(ch=='h') {System.out.println("html");}
		else if(ch=='c') {System.out.println("css");}
		//복습문제 2
		System.out.println("=========Q2===========");
		System.out.print("문자 하나를 입력하시오. >");
		char ch1 =scanner.next().charAt(0);
		switch(ch1) {
		case 'j':System.out.println("java");break;
		case 'h':System.out.println("html");break;
		case 'c':System.out.println("css");break;
		}
		//복습 문제3
		System.out.println("=========Q3===========");
		for(int num=100;num<=300;num+=100) {System.out.print(num+"\t");}
		System.out.println();
		int num=100;
		while(num<=300) {System.out.print(num+"\t");num+=100;}
		System.out.println();
		num=100;
		do {System.out.print(num+"\t");num+=100;}while(num<=300);
		System.out.println();
		//복습 문제4
		System.out.println("=========Q4===========");
		char[]arr =new char[3];
		char datas='a';
			for(int kan=0;kan<arr.length;kan++) {
				arr[kan]=datas;
				datas++;
				System.out.print(arr[kan]+"\t");}
			System.out.println();
		//복습문제5
		System.out.println("=========Q5===========");
		char[][]arr2 =new char[2][3];
		char data='a';
		for(int ch11=0;ch11<arr2.length;ch11++) {
			for(int kan=0;kan<arr2[ch11].length;kan++) {
				arr2[ch11][kan]=data;
				data++;
				System.out.print(arr2[ch11][kan]+"\t");
			}System.out.println();}
		//복습 문제6
		System.out.println("=========Q6===========");
		hi();
		hi(1);
		System.out.println(hi("sally"));
	}
	public static void hi(){System.out.println("hi");}
	public static void hi(int a){System.out.println(a);}
	public static String hi(String a){return "hi "+a;}

}
//Q7
/*<button class="btn btn-warning my-3" onclick="alert('조율비')">ONE</button>
<button class="btn btn-warning my-3" id="TWO">TWO</button>
<script>
document.getElementById("TWO").onclick.function(){alert('조율비')};
</script>*/
