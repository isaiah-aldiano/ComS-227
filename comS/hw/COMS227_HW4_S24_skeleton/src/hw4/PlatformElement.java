package hw4;

/**
 * A PlatformElement is an element with two distinctive behaviors. First, it can
 * be set up to move horizontally within a fixed set of boundaries. On reaching
 * a boundary, the x-component of its velocity is reversed. Second, it maintains
 * a list of <em>associated</em> elements whose basic motion all occurs relative
 * to the PlatformElement.
 * 
 * @author YOUR NAME HERE
 */
//TODO: This class must directly or indirectly extend AbstractElement
public class PlatformElement extends ParentableElement {

	/**
	 * Constructs a new PlatformElement. Initially the left and right boundaries are
	 * <code>Double.NEGATIVE_INFINITY</code> and
	 * <code>Double.POSITIVE_INFINITY</code>, respectively.
	 * 
	 * @param x      x-coordinate of initial position of upper left corner
	 * @param y      y-coordinate of initial position of upper left corner
	 * @param width  object's width
	 * @param height object's height
	 */
	public PlatformElement(double x, double y, int width, int height) {
		super(x, y, width, height);
	}

	@Override
	public void update() {
		// If deltaX doesn't surpass max or min call normal update
		if (getXReal() + getDeltaX() >= getMin() && (getXReal() + getWidth()) + getDeltaX() <= getMax()) {
			super.update();
		} else {
			if (getXReal() + getDeltaX() < getMin()) {
				setPosition(getMin(), getYReal());

			} else if ((getXReal() + getWidth()) + getDeltaX() > getMax()) {
				setPosition(getMax() - getWidth(), getYReal());
			}

			inverseX();
		}

		for (ViewableElement e : getAssociated()) {
			e.update();
		}
	}

}
