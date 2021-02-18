package coding;

public class Test {	
	public static void main(String[] args) {
		int a=150,b=266,c=999;
		int count=0;
		String s = String.valueOf((a*b*c));
		System.out.println(s);
		for(int i=0;i<10;i++) {
			for(int j=0;j<s.length();j++) {
				if((Integer.valueOf(s.charAt(j))-'0')==i) count++;
			}
			System.out.print(count);
			count=0;
		}
	} // main
}