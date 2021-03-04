package workshop4;

import java.util.Arrays;

public class Test02 {
	public static void main(String[] args) {
		int[] arr3 = new int[5];
		int sum=0;
		double avg = 0.0;
				
		for(int i=0;i<arr3.length;i++) {
			arr3[i]=(int)(Math.random()*10)+1;
			for(int j=0;j<i;j++) {
				if(arr3[i]==arr3[j]) {
					i--;
					break;
				}
			}
		}
		for(int i=0;i<arr3.length;i++) 
			sum+=arr3[i];
		avg=(double)sum/arr3.length;
		System.out.println(Arrays.toString(arr3));
		System.out.println("sum="+sum);
		System.out.println("avg="+avg);
		
	}
}
