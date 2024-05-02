package hw4;

/*
 * @author Isaiah Aldiano
 */
public abstract class BoundedElement extends DynamicElement {

	/*
	 * Extends abstract DynamicElement to add methods for DynamicElements that
	 * oscillate in a given area
	 */

	private double min;
	private double max;
	private double left;
	private double right;

	public BoundedElement(double x, double y, int width, int height) {
		super(x, y, width, height);
		this.min = Double.NEGATIVE_INFINITY;
		this.max = Double.POSITIVE_INFINITY;
		this.left = x;
		this.right = x + width;
	}

	/*
	 * Sets bounds for the element to oscillate between
	 */
	public void setBounds(double min, double max) {
		this.min = min;
		this.max = max;
	}

	/**
	 * @return the min
	 */
	public double getMin() {
		return min;
	}

	/**
	 * @return the max
	 */
	public double getMax() {
		return max;
	}

}
