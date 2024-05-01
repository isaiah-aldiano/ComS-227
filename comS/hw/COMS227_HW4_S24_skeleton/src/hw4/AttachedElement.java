package hw4;

/**
 * An attached element is one that is associated with another "base" element
 * such as a PlatformElement or a LiftElement. Specifically, the attached
 * element's movement is determined by the movement of the base element, the
 * element always remains a fixed distance away.
 * 
 * @author YOUR NAME HERE
 */
//TODO: This class must directly or indirectly extend AbstractElement
public class AttachedElement extends ViewableElement {

	private int offset;
	private double hover;
	private double staticY;
	private ViewableElement base;

	/**
	 * Constructs a new AttachedElement. Before being added to an associated "base"
	 * element such as a PlatformElement or LiftElement, the x and y coordinates are
	 * initialized to zero. When the base object is set (not in this constructor),
	 * the x-coordinate will be calculated as the base object's x-coordinate, plus
	 * the given offset, and the y-coordinate will become the base object's
	 * y-coordinate, minus this element's height, minus the hover amount.
	 * 
	 * @param width  element's width
	 * @param height element's height
	 * @param offset when added to a base object, this amount will be added to the
	 *               other object's x-coordinate to calculate this element's
	 *               x-coordinate
	 * @param hover  when added to a base object, this element's y-coordinate is the
	 *               other object's y-coordinate, minus this element's height, minus
	 *               the hover amount
	 */
	public AttachedElement(int width, int height, int offset, int hover) {
		super(0, 0, width, height);
		this.offset = offset; // X
		this.hover = hover; // Y
		this.staticY = 0;
	}

	public void setBase(ViewableElement base) {
		this.base = base;
		this.staticY = base.getYReal() - getHeight() - hover;
		setPosition(base.getXReal() + offset, staticY);
	}

	@Override
	public void update() {
		super.update();
		setPosition(base.getXReal() + offset, staticY);
	}

}
