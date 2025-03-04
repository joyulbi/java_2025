package com.company.java011_ex; // 1.외부 폴더
// Cat부품
// class Cat{같은 폴더에서 class 사용해야함.
public class Cat {
	public int public_;
	protected int protected_;
	int package_;
	private int private_; //Cat 내부에서만 접근 가능
	
	//alt + shift + s > getters + setters
	public int getPrivate_() {return private_;}
	public void setPrivate_(int private_) {this.private_ = private_;}
	
}
