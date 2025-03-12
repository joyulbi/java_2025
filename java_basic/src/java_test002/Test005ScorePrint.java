package java_test002;

public class Test005ScorePrint extends Score{
	public void show(Score[] std) {
		System.out.println("::::::::::::::::::::::::::::::::::::::::::::::\n이름\t국어\t영어\t수학\t평균\t합격여부\n::::::::::::::::::::::::::::::::::::::::::::::");
		for(Score s:std) {
			System.out.println(s.getName()+"\t"+s.getKor()+"\t"+s.getEng()+"\t"+s.getMath()+"\t"+String.format("%.2f", s.getAvg())+"\t"+s.getPass());
		}
	}

}
