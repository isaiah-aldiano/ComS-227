package hw4;

/*
 * @author Isaiah Aldiano
 */
public abstract class DynamicElement extends ViewableElement {

	/*
	 * Extends the abstract ViewableElement to add methods for freely moving
	 * elements
	 */

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

	/*
	 * Inverts x value
	 */
	public void inverseX() {
		deltaX *= -1;
	}

	/*
	 * Inverts y value
	 */
	public void inverseY() {
		deltaY *= -1;
	}

	/**
	 * @return the deltaY
	 */
	public double getDeltaY() {
		return deltaY;
	}

	/*
	 * Sets velocity of element
	 */
	public void setVelocity(double deltaX, double deltaY) {
		this.deltaX = deltaX;
		this.deltaY = deltaY;
	}

	/*
	 * Increases deltaY with gravity
	 */
	public void deltaYPlusGravity(double gravity) {
		this.deltaY += gravity;
	}

}
