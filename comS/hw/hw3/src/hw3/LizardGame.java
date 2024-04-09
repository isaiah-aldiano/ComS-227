package hw3;

import java.util.ArrayList;

import api.BodySegment;
import api.Cell;
import api.Direction;
import api.Exit;
import api.ScoreUpdateListener;
import api.ShowDialogListener;
import api.Wall;

/**
 * Class that models a game.
 */
public class LizardGame {
	private ShowDialogListener dialogListener;
	private ScoreUpdateListener scoreListener;
	private int width;
	private int height;
	private Cell[][] game;
	private int lizardCount;
	private ArrayList<Lizard> lizardsOnBoard;

	/**
	 * Constructs a new LizardGame object with given grid dimensions.
	 * 
	 * @param width  number of columns
	 * @param height number of rows
	 */
	public LizardGame(int width, int height) {
		this.width = width;
		this.height = height;
		setGame(width, height);

		this.lizardCount = 0;
		this.lizardsOnBoard = new ArrayList<Lizard>();
	}

	/**
	 * Get the grid's width.
	 * 
	 * @return width of the grid
	 */
	public int getWidth() {
		return width;
	}

	public Cell[][] gameBoard() {
		return game;
	}

	/**
	 * Get the grid's height.
	 * 
	 * @return height of the grid
	 */
	public int getHeight() {
		return height;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setGame(int width, int height) {
		this.game = null;
		this.game = new Cell[height][width];
		setCells(width, height);
	}

	public void setCells(int row, int col) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				Cell newCell = new Cell(i, j);
				addCell(newCell);
			}
		}
	}

	/**
	 * Adds a wall to the grid.
	 * <p>
	 * Specifically, this method calls placeWall on the Cell object associated with
	 * the wall (see the Wall class for how to get the cell associated with the
	 * wall). This class assumes a cell has already been set on the wall before
	 * being called.
	 * 
	 * @param wall to add
	 */
	public void addWall(Wall wall) {
		wall.getCell().placeWall(wall);
		game[wall.getCell().getCol()][wall.getCell().getRow()] = wall.getCell();
	}

	/**
	 * Adds an exit to the grid.
	 * <p>
	 * Specifically, this method calls placeExit on the Cell object associated with
	 * the exit (see the Exit class for how to get the cell associated with the
	 * exit). This class assumes a cell has already been set on the exit before
	 * being called.
	 * 
	 * @param exit to add
	 */
	public void addExit(Exit exit) {
		exit.getCell().placeExit(exit);
		game[exit.getCell().getCol()][exit.getCell().getRow()] = exit.getCell();
	}

	public void addCell(Cell cell) {
		if (cell.isEmpty()) {
			game[cell.getRow()][cell.getCol()] = cell;
		}
	}

	/**
	 * Gets a list of all lizards on the grid. Does not include lizards that have
	 * exited.
	 * 
	 * @return lizards list of lizards
	 */
	public ArrayList<Lizard> getLizards() {
		for (Lizard l : lizardsOnBoard) {
			l.toString();
		}
		return lizardsOnBoard;
	}

	/**
	 * Adds the given lizard to the grid.
	 * <p>
	 * The scoreListener to should be updated with the number of lizards.
	 * 
	 * @param lizard to add
	 */
	public void addLizard(Lizard lizard) {
		for (BodySegment b : lizard.getSegments()) {
			b.getCell().placeLizard(lizard);
			game[b.getCell().getCol()][b.getCell().getRow()] = b.getCell();
		}

		lizardCount++;
		lizardsOnBoard.add(lizard);
		scoreListener.updateScore(lizardCount);
	}

	/**
	 * Removes the given lizard from the grid. Be aware that each cell object knows
	 * about a lizard that is placed on top of it. It is expected that this method
	 * updates all cells that the lizard used to be on, so that they now have no
	 * lizard placed on them.
	 * <p>
	 * The scoreListener to should be updated with the number of lizards using
	 * updateScore().
	 * 
	 * @param lizard to remove
	 */
	public void removeLizard(Lizard lizard) {
		for (BodySegment b : lizard.getSegments()) {
			b.getCell().removeLizard();
			game[b.getCell().getCol()][b.getCell().getRow()] = b.getCell();
		}

		lizardCount--;
		lizardsOnBoard.remove(lizard);
		scoreListener.updateScore(lizardCount);
	}

	/**
	 * Gets the cell for the given column and row.
	 * <p>
	 * If the column or row are outside of the boundaries of the grid the method
	 * returns null.
	 * 
	 * @param col column of the cell
	 * @param row of the cell
	 * @return the cell or null
	 */
	public Cell getCell(int col, int row) {

		if (col >= this.height || row >= this.width || col < 0 || row < 0) {
			return null;
		} else {
			return game[row][col];
		}

	}

	/**
	 * Gets the cell that is adjacent to (one over from) the given column and row,
	 * when moving in the given direction. For example (1, 4, UP) returns the cell
	 * at (1, 3).
	 * <p>
	 * If the adjacent cell is outside of the boundaries of the grid, the method
	 * returns null.
	 * 
	 * @param col the given column
	 * @param row the given row
	 * @param dir the direction from the given column and row to the adjacent cell
	 * @return the adjacent cell or null
	 */
	public Cell getAdjacentCell(int col, int row, Direction dir) {
		Cell adjCell = null;

		switch (dir) {
		case RIGHT:
			if (col + 1 <= width - 1) {
				adjCell = game[col + 1][row];
			}
			break;

		case LEFT:
			if (col - 1 >= 0) {
				adjCell = game[col - 1][row];
			}
			break;

		case UP:
			if (row - 1 >= 0) {
				adjCell = game[col][row - 1];
			}
			break;

		case DOWN:
			if (row + 1 <= height - 1) {
				adjCell = game[col][row + 1];
			}
			break;
		}
		return adjCell;
	}

	/**
	 * Resets the grid. After calling this method the game should have a grid of
	 * size width x height containing all empty cells. Empty means cells with no
	 * walls, exits, etc.
	 * <p>
	 * All lizards should also be removed from the grid.
	 * 
	 * @param width  number of columns of the resized grid
	 * @param height number of rows of the resized grid
	 */
	public void resetGrid(int width, int height) {
		setHeight(height);
		setWidth(width);
		setGame(width, height);
//		for (Lizard l : lizardsOnBoard) {
//			removeLizard(l);
//		}

		lizardsOnBoard = new ArrayList<Lizard>();
	}

	/**
	 * Returns true if a given cell location (col, row) is available for a lizard to
	 * move into. Specifically the cell cannot contain a wall or a lizard. Any other
	 * type of cell, including an exit is available.
	 * 
	 * @param row of the cell being tested
	 * @param col of the cell being tested
	 * @return true if the cell is available, false otherwise
	 */
	public boolean isAvailable(int col, int row) {
		Cell isAvailable = game[col][row];
		return isAvailable.getWall() == null && isAvailable.getLizard() == null;
	}

	/**
	 * Move the lizard specified by its body segment at the given position (col,
	 * row) one cell in the given direction. The entire body of the lizard must move
	 * in a snake like fashion, in other words, each body segment pushes and pulls
	 * the segments it is connected to forward or backward in the path of the
	 * lizard's body. The given direction may result in the lizard moving its body
	 * either forward or backward by one cell.
	 * <p>
	 * The segments of a lizard's body are linked together and movement must always
	 * be "in-line" with the body. It is allowed to implement movement by either
	 * shifting every body segment one cell over or by creating a new head or tail
	 * segment and removing an existing head or tail segment to achieve the same
	 * effect of movement in the forward or backward direction.
	 * <p>
	 * If any segment of the lizard moves over an exit cell, the lizard should be
	 * removed from the grid.
	 * <p>
	 * If there are no lizards left on the grid the player has won the puzzle the
	 * the dialog listener should be used to display (see showDialog) the message
	 * "You win!".
	 * <p>
	 * It is possible that the given direction is not in-line with the body of the
	 * lizard (as described above), in that case this method should do nothing.
	 * <p>
	 * It is possible that the given column and row are outside the bounds of the
	 * grid, in that case this method should do nothing.
	 * <p>
	 * It is possible that there is no lizard at the given column and row, in that
	 * case this method should do nothing.
	 * <p>
	 * It is possible that the lizard is blocked and cannot move in the requested
	 * direction, in that case this method should do nothing.
	 * <p>
	 * <b>Developer's note: You may have noticed that there are a lot of details
	 * that need to be considered when implement this method method. It is highly
	 * recommend to explore how you can use the public API methods of this class,
	 * Grid and Lizard (hint: there are many helpful methods in those classes that
	 * will simplify your logic here) and also create your own private helper
	 * methods. Break the problem into smaller parts are work on each part
	 * individually.</b>
	 * 
	 * @param col the given column of a selected segment
	 * @param row the given row of a selected segment
	 * @param dir the given direction to move the selected segment
	 */
	public void move(int col, int row, Direction dir) {
		if (row >= width || col >= height || getCell(col, row).isEmpty()) {
			System.out.println(getCell(col, row));
			return;
		}

		Cell sel = getCell(col, row); // Selected Cell
		Lizard sel_liz = sel.getLizard(); // Lizard on cell
//		System.out.println(sel.toString());

		if (sel.getLizard() != null) {
			ArrayList<BodySegment> body = sel_liz.getSegments();
//			System.out.println(sel.toString());
			if (sel_liz.getHeadSegment().getCell().equals(sel)) {
				System.out.println(sel.toString() + "HEAD");
			} else if (sel_liz.getTailSegment().getCell().equals(sel)) {
				System.out.println(sel.toString() + "TAIL");
			} else {
				System.out.println(sel.toString() + "BODY");
			}
		}
	}

	/**
	 * Sets callback listeners for game events.
	 * 
	 * @param dialogListener listener for creating a user dialog
	 * @param scoreListener  listener for updating the player's score
	 */
	public void setListeners(ShowDialogListener dialogListener, ScoreUpdateListener scoreListener) {
		this.dialogListener = dialogListener;
		this.scoreListener = scoreListener;
	}

	/**
	 * Load the game from the given file path
	 * 
	 * @param filePath location of file to load
	 */
	public void load(String filePath) {
		resetGrid(height, width);
		GameFileUtil.load(filePath, this);
	}

	@Override
	public String toString() {
		String str = "---------- GRID ----------\n";
		str += "Dimensions:\n";
		str += getWidth() + " " + getHeight() + "\n";
		str += "Layout:\n";
		for (int y = 0; y < getHeight(); y++) {
			if (y > 0) {
				str += "\n";
			}
			for (int x = 0; x < getWidth(); x++) {
				str += getCell(x, y);
			}
		}
		str += "\nLizards:\n";
		for (Lizard l : getLizards()) {
			str += l;
		}
		str += "\n--------------------------\n";
		return str;
	}
}