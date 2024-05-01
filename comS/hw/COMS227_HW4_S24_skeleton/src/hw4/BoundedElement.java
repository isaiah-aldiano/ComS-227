package hw4;

public abstract class BoundedElement extends DynamicElement {

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
