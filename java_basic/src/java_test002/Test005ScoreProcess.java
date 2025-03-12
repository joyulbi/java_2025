package java_test002;

public class Test005ScoreProcess{
	public void process_avg(Score[] std) {
		for(Score s :std) {s.setAvg((s.getEng()+s.getMath()+s.getKor())/3.0);}
	}
	public void process_pass(Score[] std) {
		for(Score s :std) {s.setPass(s.getAvg()>60?"합격":"불합격");}

	}

}
