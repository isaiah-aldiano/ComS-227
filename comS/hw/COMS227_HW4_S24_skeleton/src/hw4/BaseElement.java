package hw4;

import java.util.ArrayList;

/*
 * @author Isaiah Aldiano
 */
public abstract class BaseElement extends BoundedElement {

	/*
	 * Extends abstract BoundedElement to add methods for elements that are capable
	 * of having attached or follower elements
	 */

	private ArrayList<ViewableElement> associatedElements;

	public BaseElement(double x, double y, int width, int height) {
		super(x, y, width, height);
		associatedElements = new ArrayList<ViewableElement>();
	}

	/*
	 * Adds a child element of type AttachedElement to the associatedElements
	 * arraylist
	 */
	public void addAssociated(AttachedElement childElement) {
		childElement.setBase(this);
		associatedElements.add(childElement);
	}

	/*
	 * Adds a child element of type FollowerElement to the associatedElements
	 * arraylist
	 */
	public void addAssociated(FollowerElement childElement) {
		childElement.setBase(this);
		associatedElements.add(childElement);
	}

	/*
	 * Deletes all elements with a true value of markedForDeletion from arrayList
	 */
	public void deleteMarkedAssociated() {
		for (int i = 0; i < associatedElements.size(); i++) {
			if (associatedElements.get(i).isMarked() == true) {
				associatedElements.remove(i);
			}
		}
	}

	/*
	 * @return the associatedElements arraylist
	 */
	public ArrayList<ViewableElement> getAssociated() {
		return associatedElements;
	}
}
