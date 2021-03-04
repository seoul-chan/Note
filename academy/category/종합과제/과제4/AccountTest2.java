package workshop4;

public class AccountTest2 {
	public static void main(String[] args) {
		Account[] ac = new Account[5];
		
		for(int i=1;i<=ac.length;i++) {
			ac[i-1]=new Account("221-0101-211"+i,100000,4.5);
		}
		
		for(int i=0;i<ac.length;i++) 
			System.out.println(ac[i].accountInfo());
		
		System.out.println();
		for(int i=0;i<ac.length;i++) {
			ac[i].setInterestRate(3.7);
			System.out.printf("%s ÀÌÀÚ: %.0f¿ø\n",ac[i].accountInfo(),ac[i].calculateInterest());
		}
	}
}
