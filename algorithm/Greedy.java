package com.algorithm;

public class Greedy {
	public static void main(String[] args) {
		// 곱하기 혹은 더하기
		// 주어진 문자열에 대해 곱하기 혹은 더하기를 하여 최대값을 출력하시오
		String s= "02984";
		
		long result=s.charAt(0)-'0';
		for(int i=1;i<s.length();i++) {
			int num=s.charAt(i)-'0';
			if(num<=1 || result<=1) result+=num;
			else result*=num;
		}
		System.out.println(result);
	}	
	
	/*
	
	public static void main(String[] args) {
		//1이 될 때까지
		// n이 k로 나누어 떨어지면 k로 나눌 수 있고
		// 그렇지 않은 경우 1을 뺄 수 있을때 n이 1이 되기까지 최소 횟수를 구하시오 
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(), k=sc.nextInt();
		int count=0;
		while(n!=1) {
			if(n%k==0) n/=k;
			else n-=1;
			count++;
		}
		System.out.println(count);
	}
	
	public static void main(String[] args) {
		/*
		 * 숫자 카드게임
		 * N : 행, M : 열
		 * 행별 가장 작은 값 구하고 그 중 제일 큰 수 구하기
		 *
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(), m=sc.nextInt();
		int[][] arr = new int[n][m];
		int[] min = new int[n];
		for(int i=0;i<n;i++) {
			int temp=10001;
			for(int j=0;j<m;j++) {
				arr[i][j]=sc.nextInt();
				if(arr[i][j]<temp) temp=arr[i][j];
			}
			min[i]=temp;			
		}
		
		int max=0;
		for(int i=0;i<n;i++)
			if(min[i]>max) max=min[i];
		System.out.println(max);
	}
	
	public static void main(String[] args) {
		/*
		 * 큰 수의 법칙
		 * n : 배열의 크기
		 * m : 숫자가 더해지는 총 횟수
		 * k : 큰 숫자가 더해지는 횟수
		 * 배열의 크기만큼 숫자가 주어지고 숫자 중 제일 큰 숫자를 m번만큼 더해준다.
		 * 단, 한번에 더할수 있는 횟수는 k번이며
		 * k번만큼 더했을 경우 두 번째 큰 숫자를 더한 후 다시 제일 큰 숫자를 더할수 있다.
		 *
		Scanner sc = new Scanner(System.in);
		
		int n=sc.nextInt(), m=sc.nextInt(), k=sc.nextInt();	
		int[] arr=new int[n];
		int sum=0;
		
		for(int i=0;i<arr.length;i++)
			arr[i]=sc.nextInt();
		
		Arrays.sort(arr);		
		for(int i=0;i<m;i++) {
			for(int j=0;j<k;j++) {
				sum+=arr[n-1];
				i++;
			}
			sum+=arr[n-2];
		}
		System.out.println(sum);
	}
	
	public static void main(String[] args) {
		// 동전 거슬러 주기
		int n = 1260;	//거스름돈
		int count=0;
		
		int[] coint_type = new int[] {500,100,50,10};
		for(int i : coint_type) {
			count=count+(n/i);
			n%=i;
		}
		System.out.println(count);
	}
	
	*/
}
