package java_test002;

public class ScorePrint_ver2 {

	public ScorePrint_ver2() {
	}

	public void show_title() {
		System.out.println(
				"=============================================================\r\n" + "이름\t국어\t영어\t수학\t평균\t합격여부\r\n"
						+ "=====================================================================================");
	}

	public void show(Score_ver2[] std) {
		show_title();
		for (Score_ver2 s : std) {
			System.out.println(s.getName() + "\t" + s.getKor() + "\t" + s.getEng() + "\t" + s.getMath() + "\t"
					+ String.format("%.2f", s.getAvg()) + "\t" + s.getPass());
		}
	}

}
