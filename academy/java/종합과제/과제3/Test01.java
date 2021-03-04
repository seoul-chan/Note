package workshop03;

public class Test01 {
	public static void main(String[] args) {		
		for(int i=2;i<=6;i++) {
			for(int j=1;j<=6;j++) {
				if(i-j>0&&i-j<=3)
					System.out.println(i+"-"+j+" = "+(i-j));
			}
		}
	}
}
