package hw4;

import api.AbstractElement;

/**
 * A follower element is one that is associated with another "base" element such
 * as a PlatformElement or LiftElement. Specifically, the follower element's
 * movement is determined by the movement of the base element, when the base
 * move up 10 pixels, the follower moves up 10 pixels. However, the follower may
 * not always be at a fixed location relative to the base. When the horizontal
 * velocity of the follower is set to a non-zero value, the follower will
 * oscillate between the left and right edges of the PlatformElement or
 * LiftElement it is associated with.
 * 
 * @author Isaiah Aldiano
 */
//TODO: This class must directly or indirectly extend AbstractElement
public class FollowerElement extends BoundedElement {

	private int offset;
	private DynamicElement base;

	/**
	 * Constructs a new FollowerElement. Before being added to a "base" element such
	 * as a PlatformElement or LiftElement, the x and y coordinates are zero. When a
	 * base element is set, the initial x-coordinate becomes the base's
	 * x-coordinate, plus the given offset, and the y-coordinate becomes the base's
	 * y-coordinate, minus this element's height.
	 * 
	 * @param width         element's width
	 * @param height        element's height
	 * @param initialOffset when added to a base, this amount will be added to the
	 *                      bases's x-coordinate to calculate this element's initial
	 *                      x-coordinate
	 */
	public FollowerElement(int width, int height, int initialOffset) {
		super(0, 0, width, height);
		this.offset = initialOffset;
	}

	/*
	 * Sets base for element
	 */
	public void setBase(AbstractElement base) {
		this.base = (DynamicElement) base;
		setPosition(base.getXReal() + offset, base.getYReal() - getHeight());
		setBounds(base.getXReal(), base.getXReal() + base.getWidth());
	}

	@Override
	public void update() {

		// Update the bounds of the FollowerElement with the size of the BaseElement
		setBounds(base.getXReal(), base.getXReal() + base.getWidth());

		// When deltaX is 0 FollowerElement acts like AttachedElement
		if (getDeltaX() == 0) {
			super.update();
			setPosition(base.getXReal() + offset, base.getYReal() - getHeight());
		} else {
			// IF x + deltaX or rightX + deltaX is within bounds update positon
			if (getXReal() + getDeltaX() >= getMin()
					&& (getXReal() + getWidth()) + getDeltaX() + base.getDeltaX() <= getMax()) {
				super.update();
				setPosition(getXReal() + getDeltaX() + base.getDeltaX(), base.getYReal() - getHeight());
			} else { // If x/rightX + deltaX leaves bounds then adjust accordingly
				if (getXReal() + getDeltaX() + base.getDeltaX() < getMin()) {
					setPosition(getMin(), base.getYReal() - getHeight());
				} else if ((getXReal() + getWidth()) + getDeltaX() + base.getDeltaX() > getMax()) {
					setPosition(getMax() - getWidth(), base.getYReal() - getHeight());
				}

				inverseX();
			}
		}
	}
}
