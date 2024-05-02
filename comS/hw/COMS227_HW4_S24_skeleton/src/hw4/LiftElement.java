package hw4;

/**
 * An element with two distinctive behaviors. First, it can be set up to move
 * vertically within a fixed set of boundaries. On reaching a boundary, the
 * y-component of its velocity is reversed. Second, it maintains a list of
 * <em>associated</em> elements whose basic motion all occurs relative to the
 * LiftElement.
 * 
 * @author Isaiah Aldiano
 */
//TODO: This class must directly or indirectly extend AbstractElement
public class LiftElement extends BaseElement {

	/**
	 * Constructs a new Elevator. Initially the upper and lower boundaries are
	 * <code>Double.NEGATIVE_INFINITY</code> and
	 * <code>Double.POSITIVE_INFINITY</code>, respectively.
	 * 
	 * @param x      x-coordinate of initial position of upper left corner
	 * @param y      y-coordinate of initial position of upper left corner
	 * @param width  element's width
	 * @param height element's height
	 */
	public LiftElement(double x, double y, int width, int height) {
		super(x, y, width, height);
	}

	@Override
	public void update() {
		// If deltaX doesn't surpass max or min call normal update
		if (getYReal() + getDeltaY() >= getMin() && (getYReal() + getHeight()) + getDeltaY() <= getMax()) {
			super.update();
			setPosition(getXReal(), getYReal() + getDeltaY());

		} else {
			// Top limit reached
			if (getYReal() + getDeltaY() < getMin()) {
				setPosition(getXReal(), getMin());

			}
			// Bottom limit reached
			else if (getYReal() + getHeight() + getDeltaX() > getMax()) {
				setPosition(getXReal(), getMax() - getHeight());
			}

			inverseY();
		}

		for (ViewableElement e : getAssociated()) {
			e.update();
		}
	}

}