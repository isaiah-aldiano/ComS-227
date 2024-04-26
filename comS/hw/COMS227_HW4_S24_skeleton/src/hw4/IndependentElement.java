package hw4;

public abstract class IndependentElement extends ViewableElement {

	private double x;
	private double y;

	public IndependentElement(double x, double y, int width, int height) {
		super(width, height);
		this.x = x;
		this.y = y;
	}

	/**
	 * @return the x as an INTEGER
	 */
	public int getX() {
		return (int) x;
	}

	/**
	 * @return the y as an INTEGER
	 */
	public int getY() {
		return (int) y;
	}

}
