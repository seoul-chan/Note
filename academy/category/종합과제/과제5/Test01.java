package workshop5;

public class Test01 {
	public static void main(String[] args) {
		char[] c = args[0].toCharArray();
		for(int i=c.length-1;i>=0;i--)
			System.out.print(c[i]);
	}
}
