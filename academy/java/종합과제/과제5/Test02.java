package workshop5;

public class Test02 {
	public static void main(String[] args) {
		Company c = new Company(100);
		System.out.printf("연 기본급 합 : %.1f 세후 : %.1f\n",c.getIncome(),c.getAfterTaxIncome());
		System.out.printf("연 보너스 합 : %.1f 세후 : %.1f\n",c.getBonus(),c.getAfterTaxBonus());
		System.out.println("연 지급액 합 : "+(c.getAfterTaxIncome()+c.getAfterTaxBonus()));
	}	
}
