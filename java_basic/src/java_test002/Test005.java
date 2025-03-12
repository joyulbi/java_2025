package java_test002;

class Score{
	private String name; private int kor; private int math; private int eng; private double avg; 
	private String pass;
	public Score() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Score(String name, int kor, int math, int eng) {
		super();
		this.name = name;
		this.kor = kor;
		this.math = math;
		this.eng = eng;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
}

public class Test005 {
	public static void main(String[] args) {
		Score[] std = new Score[3]; // std = {null, null, null} std: 3개 객체의 주소묶음
		std[0] = new Score("아이언맨", 100, 100, 100); // std = {101번지, null, null}
		std[1] = new Score("헐크", 90, 60, 80); // std = {101번지, 102번지, null}
		std[2] = new Score("블랙팬서", 20, 60, 90); // std = {101번지, 102번지, 103번지}

		Test005ScoreProcess process = new Test005ScoreProcess();
		process.process_avg(std);
		process.process_pass(std);

		Test005ScorePrint print = new Test005ScorePrint();
		print.show(std); 
		
	}
}


