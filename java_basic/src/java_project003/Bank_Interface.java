package java_project003;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Model (DTO)
class Bank_v7 {
    private String id;
    private String pass;
    private int age;
    private double balance;
    static String Company = "(주)회사";
    
    public Bank_v7(String id, String pass, int age, double balance) {
        this.id = id;
        this.pass = pass;
        this.age = age;
        this.balance = balance;
    }

    // Getter & Setter
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getPass() { return pass; }
    public void setPass(String pass) { this.pass = pass; }
    
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }

    @Override
    public String toString() {
        return Bank_v7.Company+"\nId : " + id + "\n" + "PASSWORD : " + pass + "\n" + "나이 : " + age + "\n" + "잔액 : " + balance;
    }

	public Bank_v7() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}

// Controller (기능 클래스)
interface Bank_Controller {
    void exec(List<Bank_v7> users);
}

// 계좌 추가 기능
class Input1 implements Bank_Controller {
    @Override
    public void exec(List<Bank_v7> users) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("아이디 입력: ");
        String id = scanner.next();
        System.out.print("비밀번호 입력: ");
        String pass = scanner.next();
        System.out.print("나이입력 : ");
        int age = scanner.nextInt();
        System.out.print("초기 잔액 입력: ");
        double balance = scanner.nextDouble();
        
        users.add(new Bank_v7(id, pass, age, balance));
        System.out.println("계좌가 추가되었습니다!");
    }
}

// 계좌 조회 기능
class Show implements Bank_Controller {
    @Override
    public void exec(List<Bank_v7> users) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("아이디 입력: ");
        String id = scanner.next();
        System.out.print("비밀번호 입력: ");
        String pass = scanner.next();
        
        for (Bank_v7 user : users) {
            if (user.getId().equals(id) && user.getPass().equals(pass)) {
                System.out.println("\n<<<<< 계좌조회 >>>>>");
                System.out.println(user);
                return;
            }
        }
        System.out.println("아이디 또는 비밀번호가 올바르지 않습니다.");
    }
}

// 입금 기능
class Deposit implements Bank_Controller {
    @Override
    public void exec(List<Bank_v7> users) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("아이디 입력: ");
        String id = scanner.next();
        System.out.print("비밀번호 입력: ");
        String pass = scanner.next();
        
        for (Bank_v7 user : users) {
            if (user.getId().equals(id) && user.getPass().equals(pass)) {
                System.out.print("입금할 금액 입력: ");
                double amount = scanner.nextDouble();
                user.setBalance(user.getBalance() + amount);
                System.out.println("입금 완료! 현재 잔액: " + user.getBalance());
                return;
            }
        }
        System.out.println("아이디 또는 비밀번호가 올바르지 않습니다.");
    }
}

// 출금 기능
class Withdraw implements Bank_Controller {
    @Override
    public void exec(List<Bank_v7> users) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("아이디 입력: ");
        String id = scanner.next();
        System.out.print("비밀번호 입력: ");
        String pass = scanner.next();
        
        for (Bank_v7 user : users) {
            if (user.getId().equals(id) && user.getPass().equals(pass)) {
                System.out.print("출금할 금액 입력: ");
                double amount = scanner.nextDouble();
                if (user.getBalance() >= amount) {
                    user.setBalance(user.getBalance() - amount);
                    System.out.println("출금 완료! 현재 잔액: " + user.getBalance());
                } else {
                    System.out.println("잔액이 부족합니다.");
                }
                return;
            }
        }
        System.out.println("아이디 또는 비밀번호가 올바르지 않습니다.");
    }
}

// 계좌 삭제 기능
class Delete1 implements Bank_Controller {
    @Override
    public void exec(List<Bank_v7> users) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("아이디 입력: ");
        String id = scanner.next();
        System.out.print("비밀번호 입력: ");
        String pass = scanner.next();
        
        for (Bank_v7 user : users) {
            if (user.getId().equals(id) && user.getPass().equals(pass)) {
                System.out.print("정말 삭제하시겠습니까? (Y/N): ");
                char confirm = scanner.next().charAt(0);
                if (confirm == 'Y' || confirm == 'y') {
                    users.remove(user);
                    System.out.println("계정이 삭제되었습니다.");
                } else {
                    System.out.println("삭제를 취소하셨습니다.");
                }
                return;
            }
        }
        System.out.println("아이디 또는 비밀번호가 올바르지 않습니다.");
    }
}

// View (메뉴)
class Menu7 {
    private List<Bank_v7> users;
    private Bank_Controller[] process;
    
    public Menu7() {
        users = new ArrayList<Bank_v7>();
        process = new Bank_Controller[]{ new Input1(), new Show(), new Deposit(), new Withdraw(), new Delete1() };
    }

    public void exec() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 9) {
            System.out.println("\n========= BANK =========");
            System.out.println("1. 계좌 추가");
            System.out.println("2. 계좌 조회");
            System.out.println("3. 입금");
            System.out.println("4. 출금");
            System.out.println("5. 계좌 삭제");
            System.out.println("9. 종료");
            System.out.print("선택 >> ");
            
            try {
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= 5) {
                    process[choice - 1].exec(users);
                } else if (choice != 9) {
                    System.out.println("올바른 메뉴를 선택하세요.");
                }
            } catch (Exception e) {
                scanner.next();
                System.out.println("잘못된 입력입니다.");
            }
        }
        System.out.println("프로그램을 종료합니다.");
    }
}

// Main Class
public class Bank_Interface {
    public static void main(String[] args) {
        Menu7 menu = new Menu7();
        menu.exec();
    }
}


//1.list대신 arraylist버전인거 확인 
//2.process 버전 확ㄴ
