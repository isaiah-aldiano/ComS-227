package hw2;

/**
 * Some very simple test cases as described in the assignment pdf...
 */
public class SimpleTests {
	public static void main(String[] args) {
		FuzzballGame game = new FuzzballGame(3);
//		System.out.println(game);

//        game.strike(false);
//        System.out.println(game);  // one strike
//        game.strike(false);
//        System.out.println(game);  // 0 strikes, one out
//        game.strike(false);
//        System.out.println(game);  // one strike, one out
//        game.strike(false);
//        System.out.println(game);  // 0 strike, two outs
//        game.strike(true); // batter is immediately out for swung strike
//        System.out.println(game.isTopOfInning()); // should be false now
//        System.out.println(game);         // bottom of 1st inning, 0 out
//
//        game.strike(false);
//        System.out.println(game);  // one strike
//        game.strike(false);
//        System.out.println(game);  // 0 strikes, one out
//        game.strike(false);
//        System.out.println(game);  // one strike, one out
//        game.strike(false);
//        System.out.println(game);  // 0 strike, two outs
//        game.strike(true); // batter is immediately out for swung strike
//        System.out.println(game.isTopOfInning()); // should be false now
//        System.out.println(game);         // bottom of 1st inning, 0 outs
//
//        game.strike(false);
//        System.out.println(game);  // one strike
//        game.strike(false);
//        System.out.println(game);  // 0 strikes, one out
//        game.strike(false);
//        System.out.println(game);  // one strike, one out
//        game.strike(false);
//        System.out.println(game);  // 0 strike, two outs
//        game.strike(true); // batter is immediately out for swung strike
//        System.out.println(game.isTopOfInning()); // should be false now
//        System.out.println(game);         // bottom of 1st inning, 0 outs
//
//
//        game.strike(false);
//        System.out.println(game);  // one strike
//        game.strike(false);
//        System.out.println(game);  // 0 strikes, one out
//        game.strike(false);
//        System.out.println(game);  // one strike, one out
//        game.strike(false);
//        System.out.println(game);  // 0 strike, two outs
//        game.strike(true); // batter is immediately out for swung strike
//        System.out.println(game.isTopOfInning()); // should be false now
//        System.out.println(game);         // bottom of 1st inning, 0 outs
//
//        game.strike(false);
//        System.out.println(game);  // one strike
//        game.strike(false);
//        System.out.println(game);  // 0 strikes, one out
//        game.strike(false);
//        System.out.println(game);  // one strike, one out
//        game.strike(false);
//        System.out.println(game);  // 0 strike, two outs
//        game.strike(true); // batter is immediately out for swung strike
//        System.out.println(game.isTopOfInning()); // should be false now
//        System.out.println(game);         // bottom of 1st inning, 0 outs
//
//        game.strike(false);
//        System.out.println(game);  // one strike
//        game.strike(false);
//        System.out.println(game);  // 0 strikes, one out
//        game.strike(false);
//        System.out.println(game);  // one strike, one out
//        game.strike(false);
//        System.out.println(game);  // 0 strike, two outs
//        System.out.println("Bottom of the 3rd - Game end: " + game.gameEnded());
//
//        game.strike(true); // batter is immediately out for swung strike
////        System.out.println(game.isTopOfInning()); // should be false now
//        System.out.println(game);         // bottom of 1st inning, 0 outs
//
//        System.out.println("Top of the 4th - Game end: " + game.gameEnded());

//    // try some hits, look at the bases
//    game = new FuzzballGame(3);
//    game.hit(15);
//    System.out.println(game.runnerOnBase(1)); // true
//    System.out.println(game.getBases());      // Xoo
//    game.hit(15);
//    System.out.println(game.getBases());      // XXo
//    game.hit(15);
//    System.out.println(game.getBases());      // XXX
//    game.hit(15);
//    System.out.println(game.getBases());      // XXX
//    System.out.println(game.getTeam0Score()); // 1
////
////    // try hitting a double now
//    game.hit(150);
//    System.out.println(game.getBases());      // oXX
//        game.hit(150);
//        System.out.println(game.getBases());      // oXo
//
//    System.out.println(game.getTeam0Score()); // 3
//
//    // try counting balls
//    game = new FuzzballGame(3);
//    game.ball();
//    System.out.println(game.getBallCount()); // 1
//    game.ball();
//    System.out.println(game.getBallCount()); // 2
//    game.ball();
//    System.out.println(game.getBallCount()); // 3
//    game.strike(true);
//    System.out.println(game.getBallCount()); // 0, since it's a new batter
//
//    // effect of a walk on the runners on base
//    game = new FuzzballGame(3);
//    game.hit(225);  // a triple
//    System.out.println(game.getBases());  // ooX
//    game.ball();
//    game.ball();
//    game.ball();
//    game.ball();
//    System.out.println(game.getBallCount()); // 4
//    game.ball();  //  a walk
//    System.out.println(game.getBases());  // XoX

//        game = new FuzzballGame(3);
//        game.hit(15);
//
//        System.out.println(game.getBases());  // Xoo
//        game.ball();
//        game.ball();
//        game.ball();
//        game.ball();
//        System.out.println(game.getBallCount()); // 4
//        game.ball();  //  a walk
//        System.out.println(game.getBases());  // XXo

//		game = new FuzzballGame(3);
//		game.hit(250);
//		game.hit(150);
//		game.hit(200);
//		System.out.println(game);
//
//		game.strike(true);
//		game.strike(true);
//		System.out.println(game.getBases());
//
//		game.strike(true);
//		System.out.println(game.getBases());
//
//		game.hit(250);
//
//		System.out.println(game);
//
//		System.out.println(game.getBases()); // oXo
//        game.ball();
//        game.ball();
//        game.ball();
//        game.ball();
//        System.out.println(game.getBallCount()); // 4
//        game.ball();  //  a walk
//        System.out.println(game.getBases());  // XXo
//
//        System.out.println(game);

//		game = new FuzzballGame(3);
//		game.hit(300); // point 1
//		game.hit(-1); // out 1
//		game.hit(-1); // out 2
//		System.out.println(game);
//
//		game.ball(); // 1
//		game.ball(); // 2
//		game.hit(155); // oXo
//		System.out.println(game);
//
//		game.ball(); // 3
//		game.ball(); // 4
//		game.ball(); // 5 -> 0, XXo
//		System.out.println(game);
//
//		game.strike(false); // strike 1, outs 2
//		game.hit(210); // ooX
//
//		game.ball(); // ball 1
//		System.out.println(game);
//
//		game.ball(); // ball 2
//		System.out.println(game.getCurrentOuts());
//		game.strike(false); // strike 2, outs 3, isTopOfInning == FALSE;
//		System.out.println(game.getCurrentOuts());

//		System.out.print(game.isTopOfInning());

		game = new FuzzballGame(2);
		game.strike(true);
		game.strike(true);
		game.strike(true);
		game.strike(true);
		game.strike(true);
		game.strike(true);
		game.strike(true);
		game.strike(true);
		game.strike(true);
		game.strike(true);
		game.strike(true);
		game.strike(true);
		game.hit(15);
		System.out.println(game.gameEnded());
		System.out.println(game.getBases());

//		game.hit(155);
////		System.out.println(game.getBases());
//
//		game.hit(199);
////		System.out.println(game.getBases());
//
//		game.strike(true);
////		System.out.println(game.getBases());
//
//		game.strike(true);
//		// System.out.println(game.getBases());
//
//		game.ball();
//		System.out.println(game.getBases());
//
//		game.ball();
//		System.out.println(game.getBases());
//
//		game.strike(false);
//		System.out.println(game.getBases());
//
//		game.caughtFly();
//		System.out.println(game.getBases());

//		game.hit(180);
//		game.hit(100);
//		game.ball();
//		game.ball();
//		game.strike(false);
//		game.ball();
//		game.ball();
//		game.ball();
//		game.strike(false);
//		game.ball();
//		game.ball();
//		game.strike(false);
//		game.strike(false);
//		game.ball();
//		game.ball();
//		game.ball();
//		game.hit(249);
//		game.ball();
//		game.caughtFly();
//		game.strike(false);
//		game.ball();
//		System.out.println(game);
//
//		game.strike(false);
//		System.out.println(game);
		// expected outs == 0

	}
}
