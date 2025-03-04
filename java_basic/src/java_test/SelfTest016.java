package java_test;

public class SelfTest016 {
	public static void main(String[] args) {
		int arr[][]=new int[2][3];
		int num=100;
		for(int ch = 0;ch<arr.length;ch++) {
			for(int kan=0;kan<arr[ch].length;kan++) {
				arr[ch][kan]=num;
				num++;
				System.out.print(arr[ch][kan]+" ");
			}
			System.out.println();
			num=200;
		}
	}
}
