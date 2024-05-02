
package hw4;

import java.awt.Rectangle;

import api.AbstractElement;

/*
 * @author Isaiah Aldiano
 */
public abstract class ViewableElement extends AbstractElement {

	/*
	 * Extends AbstractElement to write methods for the interface.
	 */

	private double x;
	private double y;
	private int width;
	private int height;
	private int frameCount;
	private boolean marked;
	private Rectangle rect;

	public ViewableElement(double x, double y, int width, int height) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		this.frameCount = 0;
		this.rect = new Rectangle(getXInt(), getYInt(), width, height);
	}

	/*
	 * @return int rounded value of x
	 */
	@Override
	public int getXInt() {
		return (int) Math.round(x);
	}

	/*
	 * @return int rounded value of y
	 */

	@Override
	public int getYInt() {
		return (int) Math.round(y);
	}

	/*
	 * @return width of element
	 */
	@Override
	public int getWidth() {
		return width;
	}

	/*
	 * @return height of element
	 */
	@Override
	public int getHeight() {
		return height;
	}

	/*
	 * @return hitbox of element
	 */
	@Override
	public Rectangle getRect() {
		return rect;
	}

	// Sets the position of the element
	@Override
	public void setPosition(double newX, double newY) {
		this.x = newX;
		this.y = newY;
	}

	/*
	 * @return double value of x
	 */
	@Override
	public double getXReal() {
		return x;
	}

	/*
	 * double value of y
	 */
	@Override
	public double getYReal() {
		return y;
	}

	// Updates frameCount
	@Override
	public void update() {
		frameCount++;
	}

	/*
	 * @return frameCount
	 */
	@Override
	public int getFrameCount() {
		return frameCount;
	}

	/*
	 * @return boolean value of marked
	 */
	@Override
	public boolean isMarked() {
		return marked;
	}

	// Marks an element for deletion
	@Override
	public void markForDeletion() {
		this.marked = true;
	}

	/*
	 * @return boolean for collision of two elements
	 */
	@Override
	public boolean collides(AbstractElement other) {
		// Get far x and y values of other element
		int rect1_x2 = other.getXInt() + other.getWidth();
		int rect1_y2 = other.getYInt() + other.getHeight();

		int this_x2 = getXInt() + getWidth();
		int this_y2 = getYInt() + getHeight();

		// Check if one rectangle is to the left of the other rectangle
		if (rect1_x2 <= getXInt() || this_x2 <= other.getXInt()) {
			return false;
		}

		// Check if one rectangle is above the other rectangle
		if (rect1_y2 <= getYInt() || this_y2 <= other.getYInt()) {
			return false;
		}

		return true;
	}

}
