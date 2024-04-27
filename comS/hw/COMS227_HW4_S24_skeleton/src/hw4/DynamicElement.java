package hw4;

public class DynamicElement extends ViewableElement {

	private double deltaX;
	private double deltaY;

	public DynamicElement(double x, double y, int width, int height) {
		super(x, y, width, height);
		this.deltaX = 0;
		this.deltaY = 0;
	}

	/**
	 * @return the deltaX
	 */
	public double getDeltaX() {
		return deltaX;
	}

	/**
	 * @return the deltaY
	 */
	public double getDeltaY() {
		return deltaY;
	}

	public void setVelocity(double deltaX, double deltaY) {
		this.deltaX = deltaX;
		this.deltaY = deltaY;
	}

}