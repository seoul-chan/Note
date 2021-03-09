package workshop5;

public class Company {
	private double salary;
	private double annualIncome;
	private double bonus;
	private double afterTaxBonus;
	
	public Company() {	}
	public Company(double salary) {this.salary = salary;}

	public double getSalary() {return salary;}
	public double getAnnualIncome() {return annualIncome;}
	
	public void setSalary(double salary) {this.salary = salary;}
	public void setBonus(double bonus) {this.bonus = bonus;}
	public void setAfterTaxBonus(double afterTaxBonus) {this.afterTaxBonus = afterTaxBonus;}
	public void setAnnualIncome(double annualIncome) {this.annualIncome = annualIncome;}
	
	public double getIncome() {
		return salary*12;
	}
	
	public double getAfterTaxIncome() {
		return getIncome()-getIncome()*0.1;
	}
	
	public double getBonus() {
		this.bonus=salary*0.2;
		return bonus*4;
	}
	
	public double getAfterTaxBonus() {
		this.afterTaxBonus = getBonus()-getBonus()*0.055;
		return afterTaxBonus;
	}
}
