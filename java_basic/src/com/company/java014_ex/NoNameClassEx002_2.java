package com.company.java014_ex;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

//1. 클래스는 부품객체 (멤버변수/멤버함수)
//2. 조립

class MyView2   {
	//멤버변수 (frame:틀/button:버튼) 부품 - ctrl + shift + o
	JFrame frame; JButton button;
	
	public MyView2() {
		frame = new JFrame("BOX");
		button = new JButton("BUTTON");
	}
	//멤버함수
	public void create() {
		//2-1. frame.add(컴포넌트)
		 frame.add(button);
		//2-2. frame.size(가로,세로)
		 frame.setSize(300,300);
		//2-3. frame.setVisible
		 frame.setVisible(true);
		//이벤트 대상.이벤트(핸들러); ###
			button.addActionListener(new ActionListener() {
				@Override public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "click");
				} //2) 한번쓰고 버릴 목적
			}); //3) new 인터페이스명(){implements 구현 메서드}
	}
}

public class NoNameClassEx002_2 {
	public static void main(String[] args) {
		new MyView2().create();
	}
}
