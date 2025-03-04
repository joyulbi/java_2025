package java_test;

public class SelfTest017 {
	public static void main(String[] args) {
		int arr[][]=new int[4][5];
		int num=1;
		for(int ch = 0;ch<arr.length;ch++) {
			for(int kan=0;kan<arr[ch].length;kan++) {
				arr[ch][kan]=num;
				num++;
				System.out.print(arr[ch][kan]+"\t");
			}
			System.out.println();
		}
	}
}
