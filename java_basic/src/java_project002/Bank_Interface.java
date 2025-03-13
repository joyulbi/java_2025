package java_project002;

///////////////  Model(DB :  Dto , Dao x ,DBManager x)
class Bank_v7 { 
	   private String id;
	   private String pass;
	   private double balance;
	   static String Company = "(주)회사";
	   //생성자 + toString

	  
	   
}
/////////////// Controller(기능클래스) 
interface Bank_Controller {
    void exec(Bank_v7[] users);
}
class   Input1   implements  Bank_Controller{  // 사용자에게 입력받는기능
	@Override public void exec(Bank_v7[] users) {  }
}
class   Show   implements  Bank_Controller{   // 사용자에게 조회기능
	@Override public void exec(Bank_v7[] users) {  }
}

class   Deposit   implements  Bank_Controller{ // 사용자에게 입금받는기능
	@Override public void exec(Bank_v7[] users) {  }
}
class   Withdraw   implements  Bank_Controller{// 사용자에게 출금받는기능
	@Override public void exec(Bank_v7[] users) {  }
}
class   Delete1   implements  Bank_Controller{// 사용자에게 삭제받는기능
	@Override public void exec(Bank_v7[] users) {  }
}
/////////////// View
///////////////   
class Menu7 {
	///// 멤버변수
    // Model
	Bank_v7[] users;  
	// Controller
	Bank_Controller controller;  //부모
	Bank_Controller [] process;  //자식들
    
	public Menu7() {
		users   = new Bank_v7[3];
		process = new Bank_Controller []{  new  Input1() , new Show(), new Deposit(), new Withdraw(), new Delete1() };
	} 
	///// 멤버기능
	public void exec() { 
		//메뉴판...
	}
}                

public class Bank_Interface {
	public static void main(String[] args) {
        Menu7 menu = new Menu7();
        menu.exec();
	}
}


/*
ㅁ 주어진옵션 (1)
///////////////////////
class Bank_v7 {
   // 멤버변수
   private String id;
   private String pass;
   private double balance;
   static String Company = "(주)회사";
}


ㅁ 주어진옵션 (2)
   // 기능클래스 (배열 처리기능)
   interface Bank_Controller {
      void exec(Bank_v7[] users);
   }
   
               Bank_Controller
   ↑          ↑          ↑          ↑          ↑
   Input      Show      Deposit      Withdraw   Delete   
   입력클래스    조회클래스      입력클래스      출금클래스      삭제클래스
    
ㅁ 주어진옵션 (3)
   메뉴판클래스     
   class Menu7 {
      Bank_v7[] users;
   } 

ㅁ 주어진옵션 (4) 
   public class Mini_Bank014_class007_interface2 {
      public static void main(String[] args) {
         Menu7 menu = new Menu7();
         menu.exec();
      }
   }
    
*/