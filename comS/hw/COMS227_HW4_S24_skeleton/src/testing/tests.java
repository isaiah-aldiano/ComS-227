package testing;

import hw4.AttachedElement;
import hw4.PlatformElement;
import hw4.SimpleElement;

public class tests {

	public static void main(String[] args) {
		SimpleElement e = new SimpleElement(2.3, 4.5, 10, 20);
//		System.out.println(e.getXReal()); // expected 2.3
//		System.out.println(e.getXInt()); // expected 2
//		System.out.println(e.getYReal()); // expected 4.5
//
//		System.out.println(e.getYInt()); // expected 5
//		System.out.println(e.getWidth()); // expected 10
//		System.out.println(e.getHeight());// expected 20
//		System.out.println(e.getRect());
//		// expected java.awt.Rectangle[x=2,y=5,width=10,height=20]
//		System.out.println(e.isMarked()); // expected false
//
//		// setting position
//		e.setPosition(42, 137);
//		System.out.println(e.getXReal()); // expected 42
//		System.out.println(e.getYReal()); // expected 137
//
//		// update should increment the frame count
//		e.update();
//		e.update();
//		System.out.println(e.getFrameCount()); // expected 2
//
//		// mark
//		e.markForDeletion();
//		System.out.println(e.isMarked()); // expected true

		// intersections
//		e = new SimpleElement(10, 0, 10, 10);
//		SimpleElement e2 = new SimpleElement(1, 5, 10, 10);
//		System.out.println(e.collides(e2)); // expected true
//		e2.setPosition(0, 5);
//		System.out.println(e.collides(e2)); // expected false

		// FLYING ELEMENT***********

//		FlyingElement p = new FlyingElement(0, 0, 0, 0);
//		p.setGrounded(false);
//		p.setVelocity(2, 3);
//		p.update();
//		System.out.println(p.getYReal()); // expected 3
//		System.out.println(p.getDeltaY());// expected 3
//		System.out.println();
//		p.update();
//		System.out.println(p.getYReal()); // expected 6
//		System.out.println(p.getDeltaY());// expected 3
//		System.out.println();
//
//		p.setGravity(5);
//		p.update();
//		System.out.println(p.getYReal()); // 6 + 3 = 9
//		System.out.println(p.getDeltaY()); // 3 + 5 = 8
//		System.out.println();
//
//		p.setGrounded(true);
//		p.update();
//
//		System.out.println(p.getYReal()); // 9 + 8 = 17
//		System.out.println(p.getDeltaY()); // 8 (grounded)
//		System.out.println();
//
//		p.update();
//		System.out.println(p.getYReal()); // 17 + 8 = 25
//		System.out.println(p.getDeltaY()); // 8 (grounded)

		// MOVING ELEMENT************
//		MovingElement p = new MovingElement(0, 0, 0, 0);
////		p.setGrounded(false);
//		p.setVelocity(2, 3);
//		p.update();
//		System.out.println(p.getYReal()); // expected 3
//		System.out.println(p.getDeltaY());// expected 3
//		System.out.println();
//		p.update();
//		System.out.println(p.getYReal()); // expected 6
//		System.out.println(p.getDeltaY());// expected 3
//		System.out.println();

		// VANISHING ELEMENT

//		VanishingElement p = new VanishingElement(0, 0, 0, 0, 3);
//		System.out.println(p.getLife());
//		System.out.println(p.isMarked());
//		System.out.println();
//
//		p.update();
//
//		System.out.println(p.getLife());
//		System.out.println(p.isMarked());
//		System.out.println();
//
//		p.update();
//
//		System.out.println(p.getLife());
//		System.out.println(p.isMarked());
//		System.out.println();
//
//		p.update();
//
//		System.out.println(p.getLife());
//		System.out.println(p.isMarked());
//		System.out.println();
//
//		p.update();
//
//		System.out.println(p.getLife());
//		System.out.println(p.isMarked());
//		System.out.println();

		// Platform

		// left side at x = 50, width 10, right side at 60
		PlatformElement p = new PlatformElement(50, 200, 10, 10);
		p.setBounds(40, 70);
		p.setVelocity(6, 0);
//		p.update();
//		System.out.println(p.getXReal() + ", " + (p.getXReal() + 10)); // [56, 66]
//		System.out.println("Velocity " + p.getDeltaX()); // 6.0
//		p.update();
//		System.out.println(p.getXReal() + ", " + (p.getXReal() + 10)); // [60, 70]
//		System.out.println("Velocity " + p.getDeltaX()); // -6.0
//		p.update();
//		System.out.println(p.getXReal() + ", " + (p.getXReal() + 10)); // [54, 64]
//		System.out.println("Velocity " + p.getDeltaX()); // -6.0
//		p.update();
//		System.out.println(p.getXReal() + ", " + (p.getXReal() + 10)); // [48, 58]
//		System.out.println("Velocity " + p.getDeltaX()); // -6.0
//		p.update();
//		System.out.println(p.getXReal() + ", " + (p.getXReal() + 10)); // [42, 52]
//		System.out.println("Velocity " + p.getDeltaX()); // -6.0
//		p.update();
//		System.out.println(p.getXReal() + ", " + (p.getXReal() + 10)); // [40, 50]
//		System.out.println("Velocity " + p.getDeltaX()); // 6.0

		// size 5 x 5, offset 2 units from left of PlatformElement, 15 above
		AttachedElement c = new AttachedElement(5, 5, 2, 15);
		// this should automatically make p the base of c
		p.addAssociated(c);
		// x position should be the base position + 2 = 52
		// y position should be base y - AttachedElement height - hover = 180
		System.out.println(c.getXReal()); // expected 52
		System.out.println(c.getYReal()); // expected 180
		p.update();
		System.out.println(c.getXReal()); // expected 58
		System.out.println(c.getYReal()); // expected 180
		p.update();
		System.out.println(c.getXReal()); // expected 62
		System.out.println(c.getYReal()); // expected 180
		// calling update on p should update associated elements too
		System.out.println(c.getFrameCount()); // expected 2

	}

}
