package workshop03;

import java.util.Arrays;

public class Test06 {
	public static void main(String[] args) {
		if(args.length<2 || args.length>2) {
			System.out.println("다시 입력하세요.");
			return;
		}
		double sum=0.0,avg=0.0,count=0.0;
		int row = Integer.valueOf(args[0]);
		int col =Integer.valueOf(args[1]); 
		if(row<1||row>5||col<1||col>5) {
			System.out.println("숫자를 확인하세요.");
			return;
		}
		
		int[][] arr = new int[row][col];
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				arr[i][j] = (int)(Math.random()*5+1);
				sum+=arr[i][j];
				count++;
			}
		}
		avg=sum/count;
		System.out.println(Arrays.toString(arr[0]));
		System.out.println(Arrays.toString(arr[1]));
		System.out.println();
		System.out.println("sum="+sum);
		System.out.println("avg="+avg);
	}
}
