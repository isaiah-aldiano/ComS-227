import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import api.BodySegment;
import api.Cell;
import api.Exit;
import api.Wall;
import hw3.GameFileUtil;
import hw3.Lizard;
import hw3.LizardGame;
import hw3.MockGameConsole;

public class randomTests {

	public static void test12() {
		LizardGame game = new LizardGame(20, 20);
		MockGameConsole listeners = new MockGameConsole();
		game.setListeners(listeners, listeners);
		game.addWall(new Wall(game.getCell(4, 5)));
		game.addExit(new Exit(game.getCell(5, 5)));
		Lizard liz = new Lizard();
		ArrayList<BodySegment> segments = new ArrayList<BodySegment>();
		Cell tailCell = game.getCell(1, 2);
		Cell innerCell1 = game.getCell(2, 2);
		Cell innerCell2 = game.getCell(2, 1);
		Cell headCell = game.getCell(1, 1);
		BodySegment tail = new BodySegment(liz, tailCell);
		BodySegment inner1 = new BodySegment(liz, innerCell1);
		BodySegment inner2 = new BodySegment(liz, innerCell2);
		BodySegment head = new BodySegment(liz, headCell);
		segments.add(tail);
		segments.add(inner1);
		segments.add(inner2);
		segments.add(head);
		liz.setSegments(segments);
		game.addLizard(liz);

		GameFileUtil.load("examples/speckcheck.txt", game);

		int width = game.getWidth();
		int height = game.getHeight();
		Cell wallCell = game.getCell(5, 0);
		Cell exitCell = game.getCell(7, 4);
		Cell lizardCell = game.getCell(1, 4);
		Cell emptyCell = game.getCell(1, 0);
		ArrayList<Lizard> lizards = game.getLizards();
		Lizard sal = lizards.get(0);
		Cell salHeadCell = game.getCell(2, 2);
		assertEquals("width: ", 8, width);
		assertEquals("height: ", 9, height);
		assertEquals("is wall: ", true, wallCell.getWall() != null);
		assertEquals("is exit: ", true, exitCell.getExit() != null);
		assertEquals("is lizard: ", true, lizardCell.getLizard() != null);
		assertEquals("is empty: ", true, emptyCell.isEmpty());
		assertEquals("number of lizards: ", 2, lizards.size());
		assertEquals("first lizard size is: ", 7, sal.getSegments().size());
		assertEquals("first lizard's head cell is: ", salHeadCell, sal.getHeadSegment().getCell());
	}

	public static void test19() {
		LizardGame game = new LizardGame(4, 5);
		Cell cell1 = game.getCell(1, 2);
		Cell cell2 = game.getCell(4, 4);
		Cell cell3 = game.getCell(-1, 2);
		assertEquals("Column: ", 1, cell1.getCol());
		assertEquals("Row: ", 2, cell1.getRow());
		assertEquals("Out of bounds cell: ", null, cell2);
		assertEquals("Out of bounds cell: ", null, cell3);
	}

	public static void test22() {
		LizardGame game = new LizardGame(20, 20);
		MockGameConsole listeners = new MockGameConsole();
		game.setListeners(listeners, listeners);
		game.addWall(new Wall(game.getCell(4, 5)));
		game.addExit(new Exit(game.getCell(5, 5)));
		Lizard liz = new Lizard();
		ArrayList<BodySegment> segments = new ArrayList<BodySegment>();
		Cell tailCell = game.getCell(1, 2);
		Cell innerCell1 = game.getCell(2, 2);
		Cell innerCell2 = game.getCell(2, 1);
		Cell headCell = game.getCell(1, 1);
		BodySegment tail = new BodySegment(liz, tailCell);
		BodySegment inner1 = new BodySegment(liz, innerCell1);
		BodySegment inner2 = new BodySegment(liz, innerCell2);
		BodySegment head = new BodySegment(liz, headCell);
		segments.add(tail);
		segments.add(inner1);
		segments.add(inner2);
		segments.add(head);
		liz.setSegments(segments);
		game.addLizard(liz);
		assertEquals("Is empty cell available: ", true, game.isAvailable(4, 4));
		assertEquals("Is wall cell available: ", false, game.isAvailable(4, 5));
		assertEquals("Is exit cell available: ", true, game.isAvailable(5, 5));
		assertEquals("Is lizard cell available: ", false, game.isAvailable(2, 2));

	}

	public static void test16() {
		LizardGame game = new LizardGame(4, 5);
		MockGameConsole listeners = new MockGameConsole();
		game.setListeners(listeners, listeners);
		assertEquals("Number of lizards: ", 0, game.getLizards().size());
		Lizard liz = new Lizard();
		ArrayList<BodySegment> segments = new ArrayList<BodySegment>();
		Cell tailCell = game.getCell(1, 2);
		Cell innerCell1 = game.getCell(2, 2);
		Cell innerCell2 = game.getCell(2, 1);
		Cell headCell = game.getCell(1, 1);
		BodySegment tail = new BodySegment(liz, tailCell);
		BodySegment inner1 = new BodySegment(liz, innerCell1);
		BodySegment inner2 = new BodySegment(liz, innerCell2);
		BodySegment head = new BodySegment(liz, headCell);
		segments.add(tail);
		segments.add(inner1);
		segments.add(inner2);
		segments.add(head);
		liz.setSegments(segments);
		game.addLizard(liz);
		assertEquals("Number of lizards: ", 1, game.getLizards().size());
		assertEquals("Score is: ", 1, listeners.getUpdateScoreCount());
		assertEquals("Number of times scoreListner has been updated: ", 1, listeners.getUpdateScoreCount());
		Lizard liz2 = new Lizard();
		segments = new ArrayList<BodySegment>();
		tailCell = game.getCell(1, 3);
		innerCell1 = game.getCell(1, 4);
		innerCell2 = game.getCell(2, 4);
		headCell = game.getCell(3, 4);
		tail = new BodySegment(liz2, tailCell);
		inner1 = new BodySegment(liz2, innerCell1);
		inner2 = new BodySegment(liz2, innerCell2);
		head = new BodySegment(liz2, headCell);
		segments.add(tail);
		segments.add(inner1);
		segments.add(inner2);
		segments.add(head);
		liz2.setSegments(segments);
		game.addLizard(liz2);
		assertEquals("Number of lizards: ", 2, game.getLizards().size());
		assertEquals("Score is: ", 2, listeners.getUpdateScoreCount());
		assertEquals("Number of times scoreListner has been updated: ", 2, listeners.getUpdateScoreCount());
	}

	public static void main(String args[]) {
//		test12();
//		test19();
//		test22();
		test16();
	}
}
