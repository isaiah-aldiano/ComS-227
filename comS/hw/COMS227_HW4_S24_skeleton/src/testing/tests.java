package testing;

import hw4.SimpleElement;

public class tests {

	public static void main(String[] args) {
		SimpleElement e = new SimpleElement(2.3, 4.5, 10, 20);
		System.out.println(e.getXReal()); // expected 2.3
		System.out.println(e.getXInt()); // expected 2
		System.out.println(e.getYReal()); // expected 4.5

		System.out.println(e.getYInt()); // expected 5
		System.out.println(e.getWidth()); // expected 10
		System.out.println(e.getHeight());// expected 20
		System.out.println(e.getRect());
		// expected java.awt.Rectangle[x=2,y=5,width=10,height=20]
		System.out.println(e.isMarked()); // expected false
	}

}
