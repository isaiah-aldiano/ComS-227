package exam1;

public class MeterTest {
	public static void main(String args[]) {
		ParkingMeter p = new ParkingMeter(15, 60);

		p.insertCoin(3);

		p.passTime(20);

		System.out.println(p.getTimeRemaining());
		System.out.println(p.getTotal());

		p.insertCoin(4);

		p.passTime(90);

		System.out.println(p.getTimeRemaining());
		System.out.println(p.getTotal());
	}
}
