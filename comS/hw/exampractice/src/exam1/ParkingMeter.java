package exam1;

public class ParkingMeter {

	private final double QUATER = .25;
	private int minutesPerQuarter;
	private int maximumTime;
	private int time;
	private double totalCollected;

	public ParkingMeter(int minutesPerQuarter, int maximumTime) {
		this.maximumTime = maximumTime;
		this.minutesPerQuarter = minutesPerQuarter;
		this.time = 0;
		this.totalCollected = 0;
	}

	public void insertCoin(int howMany) {
		totalCollected += howMany;

		time += minutesPerQuarter * howMany;

		if (time >= maximumTime) {
			time = maximumTime;
		}
	}

	public int getTimeRemaining() {
		return time;
	}

	public void passTime(int minutes) {
		if (time - minutes <= 0) {
			time = 0;
		} else {
			time -= minutes;
		}
	}

	public double getTotal() {
		return totalCollected * QUATER;
	}

}
