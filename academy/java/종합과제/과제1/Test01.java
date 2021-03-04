package workshop1;

public class Test01 {
	public static void main(String[] args) {
		double d1 = Double.valueOf(args[0]);
		double d2 = Double.valueOf(args[1]);
		
		if((d1%d2)>1) System.out.println("나머지가 1보다 크다");
		else System.out.println("나머지가 1보다 작거나 같다!");
		
	}
}
