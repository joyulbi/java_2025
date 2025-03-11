package java_test002;

public class ScoreProcess_ver2 {
	public ScoreProcess_ver2() {
		super();
	}

	public void process_avg(Score_ver2[] std) {
		for (Score_ver2 s : std) {
			s.setAvg((s.getKor() + s.getEng() + s.getMath()) / 3.0);
		}
	}

	public void process_pass(Score_ver2[] std) {
		for (Score_ver2 s : std) {
			s.setPass(s.getAvg() < 60 ? "불합격" : s.getKor() < 40 || s.getEng() < 40 || s.getMath() < 40 ? "재시험" : "합격");
		}
	}
} // end class
