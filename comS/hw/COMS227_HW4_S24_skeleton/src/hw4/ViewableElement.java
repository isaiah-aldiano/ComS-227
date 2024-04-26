package hw4;

import java.awt.Rectangle;

import api.AbstractElement;

public abstract class ViewableElement extends AbstractElement {
	/*
	 * Class for Flying, Lift, Moving, Platform, Simple, Vanish elements
	 */

	private int width;
	private int height;

	public ViewableElement(int width, int height) {
		this.height = height;
		this.width = width;
	}

	@Override
	public int getXInt() {
		return 0;
	}

	@Override
	public int getYInt() {
		// TODO Auto-generated method stub
		return 0;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPosition(double newX, double newY) {
		// TODO Auto-generated method stub

	}

	@Override
	public double getXReal() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getYReal() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public int getFrameCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isMarked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void markForDeletion() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean collides(AbstractElement other) {
		// TODO Auto-generated method stub
		return false;
	}

}
