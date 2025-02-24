package com.company.java006_ex;

public class RepeatEx009 {
	public static void main(String[]args) {
		//for
		for(char i='A';i<='Z';i++) { System.out.print(" "+i);
			if((i+1)%5==0) {System.out.println();}}System.out.println();
		//while
		char i='A';
		while(i<='Z') {System.out.print(" "+i);
			if((i+1)%5==0) {System.out.println();}i++;}System.out.println();
		//do while
		i='A';
		do {System.out.print(" "+i);
			if((i+1)%5==0) {System.out.println();}i++;}while(i<='Z');
	}

}
