package com.company.java011_ex;
//public(아무데서나 사용) > protected(extends) > package(같은 폴더) > private(클래스내)
public class Milk {
	private int mmo;
	private String mname;
	private int mprice;
	
	public int getMmo() {return mmo;}
	public void setMmo(int mmo) {this.mmo = mmo;}
	public String getMname() {return mname;}
	public void setMname(String mname) {this.mname = mname;}
	public int getMprice() {return mprice;}
	@Override
	public String toString() {
		return "Milk [mmo=" + mmo + ", mname=" + mname + ", mprice=" + mprice + "]";
	}
	public void setMprice(int i) {this.mprice=i;}
	
}
