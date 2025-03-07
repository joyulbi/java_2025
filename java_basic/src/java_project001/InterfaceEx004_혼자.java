package java_project001;

interface Launch {int Money=10000; void eat();}

class Burger implements Launch{
	int price;
	public Burger() {this.price=3900; }
	@Override public void eat() {System.out.println("Burger 냠냠");  }
	@Override public String toString() { return "Burger"; } 
}
class KimchiStew implements Launch{
	int price;
	public KimchiStew() {this.price=4000;}
	@Override public void eat() {System.out.println("KimchiStew 냠냠");  }
	@Override public String toString() { return "KimchiStew"; } 
}
class User{
	int money; int cnt; int total=0;
	Launch[]plate;
	User(){money=Launch.Money; plate=new Launch[3]; cnt=0;  }
	
	void order(Launch l) {
		for(int i=0;i<3;i++) {if(cnt<3) {plate[i]=l;} cnt++;}
	}

	void show() {
		for(int i=0;i<3;i++){
			System.out.println(plate[i]);
			total+=plate[i] instanceof Burger?3900:4000;
			//System.out.println(plate[i] instanceof Burger?"버거":"김치");
			}
		System.out.println(total);
		System.out.println("2022년 12월 16일");
	}
}

public class InterfaceEx004_혼자 {
	public static void main(String[] args) {
		User launchorder = new User();
		
		launchorder.order(new Burger());
		launchorder.order(new KimchiStew());
		
		launchorder.order(new Burger());
	
		launchorder.show();
		
	}
}
