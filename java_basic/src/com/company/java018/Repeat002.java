package com.company.java018;

class TestA2{
	int  a = 10;
	public TestA2() { super();  }
	@Override public String toString() { return "TestA2 [a=" + a + "]"; }
}
class TestB2 extends  TestA2{ 
	int b=20;
	public TestB2() { super();  }
	@Override public String toString() { return "TestB2 [b=" + b + "]"; }
}

	

public class Repeat002 {
	public static void main(String[] args) {        
		TestA2   ta = new TestA2();    // [ ta   [a]  ]
		System.out.println(ta);
		//TestB2   tb = ta;                   // [ tb   [b]-[a]  ]
		// 오류나는 이유는? 
		//자식 = 부모/다운캐스팅/타입캐스팅
		
		//해결방안
		ta= new TestB2();
		TestB2   tb = (TestB2)ta;
		System.out.println(tb);
		//자식 = 부모/다운캐스팅/타입캐스팅 - 부모는 자식생성자를 호출한 적이 있어야 한다.
	}
}


/*class TestA2{
			int  a = 10;
			public TestA2() { super();  }
			@Override public String toString() { return "TestA2 [a=" + a + "]"; }
		}
		class TestB2 extends  TestA2{ 
			int b=20;
			public TestB2() { super();  }
			@Override public String toString() { return "TestB2 [b=" + b + "]"; }
		}
		public class ExtendsBasic009_2_Polymorphism2_short {
			public static void main(String[] args) {        
				TestA2   ta = new TestA2();    // [ ta   [a]  ]
				TestB2   tb = ta;                   // [ tb   [b]-[a]  ]
				// 오류나는 이유는? 
			}
		 }*/