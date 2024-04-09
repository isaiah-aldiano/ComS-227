package hw3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import api.BodySegment;
import api.Cell;
import api.Exit;
import api.Wall;

/**
 * Utility class with static methods for loading game files.
 */
public class GameFileUtil {
	/**
	 * Loads the file at the given file path into the given game object. When the
	 * method returns the game object has been modified to represent the loaded
	 * game.
	 * 
	 * @param filePath the path of the file to load
	 * @param game     the game to modify
	 * @throws FileNotFoundException
	 */
	public static void load(String filePath, LizardGame game) {
		File file = new File(filePath);
		Scanner scnr;
		int lineNum = -1;

		try {

			scnr = new Scanner(file);
			String[] currLine;
			while (scnr.hasNext()) {
				String line = scnr.nextLine();

				if (lineNum == -1) {
					currLine = line.split("x");
					game.resetGrid(Integer.parseInt(currLine[0]), Integer.parseInt(currLine[1]));

					lineNum = 0;
				} else if (line.charAt(0) == 'L') {
					currLine = line.split(" ");
					Lizard l = new Lizard();
					ArrayList<BodySegment> b = new ArrayList<BodySegment>();
					for (int i = 1; i < currLine.length; i++) {
						String[] newCell = currLine[i].split(",");
						Cell c = new Cell(Integer.parseInt(newCell[1]), Integer.parseInt(newCell[0]));
						BodySegment bs = new BodySegment(l, c);
						b.add(bs);
					}

					l.setSegments(b);
					game.addLizard(l);
				} else {
					char[] maze = line.toCharArray();

					for (int j = 0; j < maze.length - 1; j++) {
						Cell newCell = new Cell(lineNum, j);
						if (maze[j] == 'W') {
//							newCell = new Cell(j, lineNum);
							Wall newWall = new Wall(newCell);
//							System.out.print(newWall.getCell().toString());
							game.addWall(newWall);
//							System.out.print(newWall.getCell().toString());

						} else if (maze[j] == 'E') {
//							newCell = new Cell(j, lineNum);
							Exit exit = new Exit(newCell);
							game.addExit(exit);
						} else {
							newCell = new Cell(j, lineNum);
							game.addCell(newCell);
						}
					}
					lineNum++;

//					System.out.println();
				}

			}
			Cell[][] gameBoard = game.gameBoard();
			for (Cell[] i : gameBoard) {
				for (Cell j : i) {
//					System.out.print(j.toString());
					if (j.getLizard() != null) {
						System.out.print("L");
					} else if (j.getWall() != null) {
						System.out.print("W");
					} else if (j.getExit() != null) {
						System.out.print("E");
					} else if (j.isEmpty() == true) {
						System.out.print(" ");
					}
				}
				System.out.println();
			}
		} catch (FileNotFoundException e) {
			System.out.print("FILE " + file + " NOT FOUND!");
		}
	}
}