package workshop03;

import java.util.Calendar;

public class Months {
	private Calendar cal = Calendar.getInstance();
			
	public int getDays(int months) {
		cal.set(Calendar.MONTH, months-1);
		return cal.getActualMaximum(Calendar.DATE);
	}
}
