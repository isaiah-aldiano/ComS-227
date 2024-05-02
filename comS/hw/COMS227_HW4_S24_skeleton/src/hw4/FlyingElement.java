package hw4;

/**
 * Moving element in which the vertical velocity is adjusted each frame by a
 * gravitational constant to simulate gravity. The element can be set to
 * "grounded", meaning gravity will no longer influence its velocity.
 * 
 * @author Isaiah Aldiano
 */
//TODO: This class must directly or indirectly extend AbstractElement
public class FlyingElement extends DynamicElement {

	private boolean grounded;
	private double gravity;

	/**
	 * Constructs a new FlyingElement. By default it should be grounded, meaning
	 * gravity does not influence its velocity.
	 * 
	 * @param x      x-coordinate of upper left corner
	 * @param y      y-coordinate of upper left corner
	 * @param width  element's width
	 * @param height element's height
	 */

	public FlyingElement(double x, double y, int width, int height) {
		super(x, y, width, height);
		this.grounded = false;
		this.gravity = 0;
	}

	/*
	 * Sets gravity of flying element
	 */
	public void setGravity(double gravity) {
		this.gravity = gravity;
	}

	/*
	 * Sets boolean value of grounded
	 */
	public void setGrounded(boolean grounded) {
		this.grounded = grounded;
	}

	/*
	 * @return value of grounded
	 */
	public boolean isGrounded() {
		return grounded;
	}

	@Override
	public void update() {
		super.update();

		setPosition(getXReal() + getDeltaX(), getYReal() + getDeltaY());

		// If not grounded update deltaY with gravity given
		if (grounded == false) {
			deltaYPlusGravity(gravity);
		}

	}

}
