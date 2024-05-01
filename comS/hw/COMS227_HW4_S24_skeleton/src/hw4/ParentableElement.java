package hw4;

import java.util.ArrayList;

public abstract class ParentableElement extends BoundedElement {

	private ArrayList<ViewableElement> associatedElements;

	public ParentableElement(double x, double y, int width, int height) {
		super(x, y, width, height);
		associatedElements = new ArrayList<ViewableElement>();
	}

	public void addAssociated(AttachedElement childElement) {
		childElement.setBase(this);
		associatedElements.add(childElement);
	}

	public void addAssociated(FollowerElement childElement) {
		childElement.setBase(this);
		associatedElements.add(childElement);
	}

	public void deleteMarkedAssociated() {
		for (ViewableElement child : associatedElements) {
			if (child.isMarked()) {
				associatedElements.remove(child);
			}
		}
	}

	public ArrayList<ViewableElement> getAssociated() {
		return associatedElements;
	}
}
