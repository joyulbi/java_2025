package java_test002;

import java.util.HashSet;
import java.util.Set;

public class SetEx003 {
	public static void main(String[] args) {
		Set<Integer> lotto = new HashSet<>();
//		for(int i = 1;i<46;i++) {lotto.add(i);}
//		System.out.println(lotto);
		
		while(lotto.size()<6) {
			lotto.add(   (int)(Math.random()*45)+1  );
		}
		System.out.println(lotto);
	}
}
/*
연습문제3)  Collection  Framework
패키지명 : com.company.java015_ex
클래스명 : SetEx003
- 중복되는 숫자없이  랜덤으로 숫자6개를 받는 로또(1~45)를 만들려고 한다.
1. 알맞은 콜렉션프레임워크는?    Set
  > 동적배열 - 객체만 저장
  > List   - 기차  : index(O), 중복허용(O)  , add/get/size/remove/contains
  > Set    - 주머지 :index(X), 중복허용(X)  , add/get(X) 향for,Iterator/size/remove/contains
  > Map
2. 프로그램을 작성하시오.
 
*/