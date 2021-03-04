package workshop4;

public class Test05 {
	public static void main(String[] args) {
		int data = Integer.valueOf(args[0]);
		int sum=0;
		String str ="";
		
		for(int i=data;i<=10;i++) {
			if(i%3==0 || i%5==0) continue;
			sum+=i;
			str+=i+"+";
		}
		System.out.println(str.substring(0,str.length()-1));
		System.out.println("°á°ú : "+sum);
	}
}
