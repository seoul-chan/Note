package workshop03;

public class MonthsTest {
	public static void main(String[] args) {
		int months = Integer.valueOf(args[0]);
		if(months<1||months>12) {
			System.out.println("입력된 값이 잘못 되었습니다.");
			return;
		}
		
		Months m = new Months();
		
		System.out.printf("입력 받은 월 : %s월\n",months);
		System.out.printf("마지막 일자 : %s일",m.getDays(months));
	}
}
