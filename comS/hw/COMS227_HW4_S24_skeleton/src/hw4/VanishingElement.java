package hw4;

/**
 * An element that does not move. Instead, it is intended to appear on the
 * screen for a fixed number of frames.
 * 
 * @author YOUR NAME HERE
 */
//TODO: This class must directly or indirectly extend AbstractElement
public class VanishingElement extends ViewableElement {

	private int life;

	/**
	 * Constructs a new VanishingElement.
	 * 
	 * @param x           x-coordinate of upper left corner
	 * @param y           y-coordinate of upper left corner
	 * @param width       element's width
	 * @param height      element's height
	 * @param initialLife the number of frames until this element marks itself for
	 *                    deletion
	 */
	public VanishingElement(double x, double y, int width, int height, int initialLife) {
		super(x, y, width, height);
		this.life = initialLife;
	}

	// TODO: everything

	public int getLife() {
		return life;
	}

	@Override
	public void update() {
		super.update();

		if (life > 0) {
			life -= 1;
		}

		if (life == 0 && isMarked() == false) {
			markForDeletion();
		}
	}

}
