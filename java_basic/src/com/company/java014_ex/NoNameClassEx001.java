/*package com.company.java014_ex;

interface Calc{public double exec(double num1,double num2);}
class Cal implements Calc{
	@Override public double exec(double num1, double num2) {  return num1+num2; }
 }

public class NoNameClassEx001 {
	public static void main(String[] args) {
		Calc c = new Cal(); 
		System.out.println(c.exec(10, 3));
	}

}*/
package com.company.java014_ex;

interface Calc{public double exec(double num1,double num2);}

public class NoNameClassEx001 {
	public static void main(String[] args) {
		Calc c = new Calc() {
			@Override public double exec(double num1, double num2) {return num1+num2; }
		};
		System.out.println(c.exec(10, 3));
		//interface
		//Calc calc = new Calc();         (X)
		//Calc calc = new Calc(){메서드 구현}; (O)
	}

}