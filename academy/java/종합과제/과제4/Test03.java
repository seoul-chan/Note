package workshop4;

import java.util.Arrays;

public class Test03 {
	public static void main(String[] args) {
		int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
		
		int max=0,position=0;
		for(int i=0;i<arr.length-1;i++) {
			max=arr[i];
			position=i;
			for(int j=i+1;j<arr.length;j++) {
				if(max<arr[j]) {
					max=arr[j];
					position=j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[position];
			arr[position] = temp;
		}
		System.out.println(Arrays.toString(arr));
	}
}
