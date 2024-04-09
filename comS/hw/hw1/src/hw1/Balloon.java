package hw1;

/**
 * 
 * @author isaiah This Balloon class can be used to simulate a balloon and how
 *         it would act depending on wind direction, temperature, fuel, fuel
 *         burn rate. and tether length
 *
 */
public class Balloon {

	private double outsideAirTemp;
	private double windDirection;
	private double balloonTemp;
	private double fuelRemaining;
	private double fuelBurnRate;
	private double balloonMass;
	private double velocity;
	private double tetherLength;
	private double altitude;

	private double initOAT;
	private double initWD;

	private double Fg;
	private double Fl;

	private double HEAT_LOSS_FACTOR = 0.1;
	private final int AIR_VOL_BALLOON = 61234;
	private final double G = 9.81;
	private final double GAS_CONST_R = 287.05;
	private final double STD_PRESSURE = 1013.25;
	private final double KELVIN = 273.15;

	private long seconds;

	private double tempChange;

	/**
	 * Constructs a Balloon given airTemp (celsius) and windDirection (degrees)
	 * 
	 * @return circumference of this Basketball
	 */
	public Balloon(double outsideAirTemp, double windDirection) {
		this.outsideAirTemp = outsideAirTemp;
		this.windDirection = windDirection + 720;
		this.balloonTemp = outsideAirTemp;
		this.initOAT = outsideAirTemp;
		this.initWD = windDirection;
		this.altitude = 0;
		this.fuelRemaining = 0;
		this.fuelBurnRate = 0;
		this.balloonMass = 0;
		this.velocity = 0;
		this.tetherLength = 0;

		this.seconds = 0;
	}

	/**
	 * Updates seconds by 1 and calls methods to update balloons position and
	 * temperature
	 */
	public void update() {
		calcFuel(this.getFuelBurnRate());
		calcTempChange();
		setBalloonTemp(this.getBalloonTemp() + tempChange);
		setVelocity();
		setAltitude();
		seconds += 1;
	}

	/**
	 * @param calculates change in temperature of balloon after 1 second
	 */
	private void calcTempChange() {
		this.tempChange = this.getFuelBurnRate()
				+ (this.getOutsideAirTemp() - this.getBalloonTemp()) * HEAT_LOSS_FACTOR;
	}

	/**
	 * 
	 * @param of the fuel burn rate, calculates fuel burn rate and ensures proper
	 *           amount of fuel burn
	 */
	private void calcFuel(double fuelBurned) {
		this.setFuelBurnRate(Math.min(this.fuelBurnRate, this.fuelRemaining));
		this.setFuelRemaning(Math.max(0, this.fuelRemaining - fuelBurned));

	}

	/**
	 * @returns the surrounding air density in net upward force equation
	 */
	private double calcSurrAirDensity() {
		return (STD_PRESSURE) / (GAS_CONST_R * (this.getOutsideAirTemp() + KELVIN));
	}

	/**
	 * @return the balloon air density in the net upward force equation
	 */
	private double calcBalloonAirDensity() {
		return (STD_PRESSURE) / (GAS_CONST_R * (this.getBalloonTemp() + KELVIN));
	}

	/**
	 * @return the Net Upward force used in the acceleration part of the velocity
	 *         equation
	 */
	private double calcNetUpwardForce() {
		this.Fg = this.getBalloonMass() * G;

		this.Fl = AIR_VOL_BALLOON * (this.calcSurrAirDensity() - this.calcBalloonAirDensity()) * G;
		return Fl - Fg;
	}

	/**
	 * Sets velocity using Net Force and mass
	 */
	private void setVelocity() {

		this.velocity = (this.getVelocity() + (this.calcNetUpwardForce() / this.getBalloonMass()));
	}

	/**
	 * Sets altitude to a maximum of the length of the tether or current altitude +
	 * the velocity
	 */
	private void setAltitude() {
		this.altitude = Math.min(this.getTetherLength(), this.getAltitude() + this.getVelocity());
	}

	/**
	 * @param Temperature outside of the balloon
	 */
	public void setOutsideAirTemp(double outsideAirTemp) {
		this.outsideAirTemp = outsideAirTemp;
	}

	/**
	 * @param Temperature inside the balloon
	 */
	public void setBalloonTemp(double balloonTemp) {
		this.balloonTemp = balloonTemp;
	}

	/**
	 * @param fuelRemaining the fuelRemaining to set
	 */
	public void setFuelRemaning(double fuelRemaining) {
		this.fuelRemaining = fuelRemaining;
	}

	/**
	 * @param fuelBurnRate the fuelBurnRate to set
	 */
	public void setFuelBurnRate(double fuelBurnRate) {
		this.fuelBurnRate = fuelBurnRate;
	}

	/**
	 * @param balloonMass the balloonMass to set
	 */
	public void setBalloonMass(double balloonMass) {
		this.balloonMass = balloonMass;
	}

	/**
	 * @param tetherLength the tetherLength to set
	 */
	public void setTetherLength(double tetherLength) {
		this.tetherLength = tetherLength;
	}

	/**
	 * Updates the wind direction by adding the giving value (which is assumed to be
	 * between -360 and 360 exclusive)
	 * 
	 * @return the windDirection
	 */
	public void changeWindDirection(double deg) {
		windDirection = (windDirection + deg);
	}

	/**
	 * @return the outsideAirTemp
	 */
	public double getOutsideAirTemp() {
		return outsideAirTemp;
	}

	/**
	 * @return the balloonTemp
	 */
	public double getBalloonTemp() {
		return balloonTemp;
	}

	/**
	 * @return the fuelRemaining
	 */
	public double getFuelRemaining() {
		return fuelRemaining;
	}

	/**
	 * @return the fuelBurnRate
	 */
	public double getFuelBurnRate() {
		return fuelBurnRate;
	}

	/**
	 * @return the balloonMass
	 */
	public double getBalloonMass() {
		return balloonMass;
	}

	/**
	 * @return the tetherLength
	 */
	public double getTetherLength() {
		return tetherLength;
	}

	/**
	 * @return the windDirection modulus 360 to be 0 >= X < 360
	 */
	public double getWindDirection() {
		return windDirection % 360;
	}

	/**
	 * @param tetherLength the tetherLength to set
	 */
	public double getTetherRemaining() {
		return Math.max(0, tetherLength - altitude);
	}

	/**
	 * @return the velocity
	 */
	public double getVelocity() {

		return velocity;
	}

	/**
	 * @return the altitude so its A <= 0
	 */
	public double getAltitude() {
		return Math.max(altitude, 0);
	}

	/**
	 * @return the seconds divided by 60 to get minutes
	 */
	public long getMinutes() {
		return seconds / 60;
	}

	/**
	 * @return the seconds modulus 60 to be S < 60
	 */
	public long getSeconds() {
		return seconds % 60;
	}

	/**
	 * Resets all instance variables back to their original values
	 */
	public void reset() {
		this.outsideAirTemp = initOAT;
		this.windDirection = initWD + 720;
		this.balloonTemp = initOAT;
		this.altitude = 0;
		this.fuelRemaining = 0;
		this.fuelBurnRate = 0;
		this.balloonMass = 0;
		this.velocity = 0;
		this.tetherLength = 0;

		this.seconds = 0;
	}

}
