package workshop1;

public class Test02 {
	public static void main(String[] args) {
		int intArgs = Integer.valueOf(args[0]);
		
		if(intArgs<5||intArgs>10) {
			System.out.println("다시 입력하세요"); 
			return;
		}
		
		double sum=0.0,multi=1.0,aver=0.0;
		for(int i=1;i<=intArgs;i++) {
			sum+=i;
			multi*=i;
		}
		aver=sum/intArgs;
		System.out.println("합 : "+sum);
		System.out.println("곱 : "+multi);
		System.out.println("평균 : "+aver);		
	}
}
