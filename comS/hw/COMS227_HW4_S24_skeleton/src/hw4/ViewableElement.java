package hw4;

import java.awt.Rectangle;

import api.AbstractElement;

public abstract class ViewableElement extends AbstractElement {
	/*
	 * Class for Flying, Lift, Moving, Platform, Simple, Vanish elements
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
		this.rect = new Rectangle((int) x, (int) y, width, height);
	}

	@Override
	public int getXInt() {
		return (int) Math.round(x);
	}

	@Override
	public int getYInt() {
		return (int) Math.round(y);
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public Rectangle getRect() {
		return rect;
	}

	@Override
	public void setPosition(double newX, double newY) {
		this.x = newX;
		this.y = newY;
	}

	@Override
	public double getXReal() {
		return x;
	}

	@Override
	public double getYReal() {
		return y;
	}

	@Override
	public void update() {
		frameCount++;
	}

	@Override
	public int getFrameCount() {
		return frameCount;
	}

	@Override
	public boolean isMarked() {
		return marked;
	}

	@Override
	public void markForDeletion() {
		this.marked = true;
	}

	@Override
	public boolean collides(AbstractElement other) {
		// Calculate coordinates of the bottom-right corner for the first rectangle
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
