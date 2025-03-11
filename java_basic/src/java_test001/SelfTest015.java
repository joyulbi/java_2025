package java_test001;

public class SelfTest015 {
	public static void main(String[] args) {
		int arr[]=new int[5];
		arr[0]=1;
		arr[1]=2;
		for(int i = 0;i<arr.length;i++) {
			arr[i]=i+1;
			System.out.println(arr[i]);
		}
	}
}
