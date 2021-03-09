package workshop5;

public class MobileTest {
	public static void main(String[] args) {
		Ltab lt = new Ltab("Ltab",500,"AP-01");
		Otab ot = new Otab("Otab",1000,"AND-20");
		
		System.out.println("Mobile\tBattery\tOS");
		System.out.println("-------------------");
		System.out.println(lt.getMobileName()+"\t"+lt.getBatterySize()+"\t"+lt.getOsType());
		System.out.println(ot.getMobileName()+"\t"+ot.getBatterySize()+"\t"+ot.getOsType());
		System.out.println();
		
		lt.charge(10);
		ot.charge(10);
		System.out.println("Mobile\tBattery\tOS");
		System.out.println("-------------------");
		System.out.println(lt.getMobileName()+"\t"+lt.getBatterySize()+"\t"+lt.getOsType());
		System.out.println(ot.getMobileName()+"\t"+ot.getBatterySize()+"\t"+ot.getOsType());
		System.out.println();
		
		System.out.println("Mobile\tBattery\tOS");
		System.out.println("-------------------");
		lt.operate(5);
		ot.operate(5);
		System.out.println(lt.getMobileName()+"\t"+lt.getBatterySize()+"\t"+lt.getOsType());
		System.out.println(ot.getMobileName()+"\t"+ot.getBatterySize()+"\t"+ot.getOsType());
		System.out.println();
		
		
		
	}
}
