package hw4;

import api.AbstractElement;

public abstract class DependentElement extends ViewableElement {
	/*
	 * Class for FollowerElement and AttatchedElement
	 */

	private int offSet;
	private int hover;

	public DependentElement(int width, int height, int offSet) {
		super(width, height);
		this.offSet = offSet;

	}

	public DependentElement(int width, int height, int offSet, int hover) {
		super(width, height);
		this.offSet = offSet;
		this.hover = hover;
	}

	public void setBase(AbstractElement base) {

	}

}
