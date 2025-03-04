package com.company.java011_ex;

public class Score2process {

	public void process_avg(Score2[] std) { // 주소 따라가서 데이터 수정하겠습니다. 
		//System.out.println("process_avg 주소확인 : "+System.identityHashCode(std));
		//std[0].avg = (std[0].kor + std[0].eng +std[0].math)/3;
		//std[0].setAvg((std[0].getKor() + std[0].getEng() +std[0].getMath())/3);
		for(int i =0; i<std.length;i++){std[i].setAvg((std[i].getKor() + std[i].getEng() +std[i].getMath())/3.0);}
	}
	public void process_pass(Score2[] std) {
		//System.out.println("process_pass 주소확인 : "+System.identityHashCode(std));
		//std[0].pass = std[0].aver>=60?"합격":"불합격";
		//getters/setters
		//std[0].setPass(std[0].getAvg()>=60?"합격":"불합격");
		for(int i =0; i<std.length;i++) {std[i].setPass(std[i].getAvg()>=60?"합격":"불합격");}
	}

}
