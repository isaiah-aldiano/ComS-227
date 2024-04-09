package hw3;

import java.util.ArrayList;

import api.BodySegment;
import api.Cell;
import api.Direction;

/**
 * Represents a Lizard as a collection of body segments.
 */
public class Lizard {
	private ArrayList<BodySegment> body;

	/**
	 * Constructs a Lizard object.
	 */
	public Lizard() {
		this.body = new ArrayList<BodySegment>();
	}

	/**
	 * Sets the segments of the lizard. Segments should be ordered from tail to
	 * head.
	 * 
	 * @param segments list of segments ordered from tail to head
	 */
	public void setSegments(ArrayList<BodySegment> segments) {
		this.body = segments;
	}

	/**
	 * Gets the segments of the lizard. Segments are ordered from tail to head.
	 * 
	 * @return a list of segments ordered from tail to head
	 */
	public ArrayList<BodySegment> getSegments() {
		return this.body;
	}

	/**
	 * Gets the head segment of the lizard. Returns null if the segments have not
	 * been initialized or there are no segments.
	 * 
	 * @return the head segment
	 */
	public BodySegment getHeadSegment() {
		return body.get(body.size() - 1);
	}

	/**
	 * Gets the tail segment of the lizard. Returns null if the segments have not
	 * been initialized or there are no segments.
	 * 
	 * @return the tail segment
	 */
	public BodySegment getTailSegment() {
		return body.get(0);
	}

	/**
	 * Gets the segment that is located at a given cell or null if there is no
	 * segment at that cell.
	 * 
	 * @param cell to look for lizard
	 * @return the segment that is on the cell or null if there is none
	 */
	public BodySegment getSegmentAt(Cell cell) {
		BodySegment someCell = null;

		for (BodySegment b : body) {
			if (b.getCell() == cell) {
				someCell = b;
			}
		}

		return someCell;
	}

	/**
	 * Get the segment that is in front of (closer to the head segment than) the
	 * given segment. Returns null if there is no segment ahead.
	 * 
	 * @param segment the starting segment
	 * @return the segment in front of the given segment or null
	 */
	public BodySegment getSegmentAhead(BodySegment segment) {
		BodySegment b = null;

		for (int i = 0; i < body.size(); i++) {
			if (body.get(i).equals(segment) && !this.getHeadSegment().equals(segment)) {
				b = body.get(i + 1);
			}
		}

		return b;

	}

	/**
	 * Get the segment that is behind (closer to the tail segment than) the given
	 * segment. Returns null if there is not segment behind.
	 * 
	 * @param segment the starting segment
	 * @return the segment behind of the given segment or null
	 */
	public BodySegment getSegmentBehind(BodySegment segment) {
		BodySegment b = null;

		for (int i = 0; i < body.size(); i++) {
			if (body.get(i).equals(segment) && !this.getTailSegment().equals(segment)) {
				b = body.get(i - 1);
			}
		}

		return b;
	}

	/**
	 * Gets the direction from the perspective of the given segment point to the
	 * segment ahead (in front of) of it. Returns null if there is no segment ahead
	 * of the given segment.
	 * 
	 * @param segment the starting segment
	 * @return the direction to the segment ahead of the given segment or null
	 */
	public Direction getDirectionToSegmentAhead(BodySegment segment) {
		Direction d = null;
		BodySegment b = getSegmentAhead(segment);

		if (segment != this.getHeadSegment()) {
			int row1 = segment.getCell().getRow();
			int col1 = segment.getCell().getCol();

			int row2 = b.getCell().getRow();
			int col2 = b.getCell().getCol();

			if (row1 == row2) {
				if (col1 < col2) {
					d = Direction.RIGHT;
				} else {
					d = Direction.LEFT;
				}
			} else {
				if (row1 < row2) {
					d = Direction.DOWN;
				} else {
					d = Direction.UP;
				}
			}
		}

		return d;
	}

	/**
	 * Gets the direction from the perspective of the given segment point to the
	 * segment behind it. Returns null if there is no segment behind of the given
	 * segment.
	 * 
	 * @param segment the starting segment
	 * @return the direction to the segment behind of the given segment or null
	 */
	public Direction getDirectionToSegmentBehind(BodySegment segment) {
		Direction d = null;
		BodySegment b = getSegmentBehind(segment);

		if (segment != getTailSegment()) {
			int row1 = segment.getCell().getRow();
			int col1 = segment.getCell().getCol();

			int row2 = b.getCell().getRow();
			int col2 = b.getCell().getCol();

			if (row1 == row2) {
				if (col1 < col2) {
					d = Direction.RIGHT;
				} else {
					d = Direction.LEFT;
				}
			} else {
				if (row1 < row2) {
					d = Direction.DOWN;
				} else {
					d = Direction.UP;
				}
			}
		}
		return d;
	}

	/**
	 * Gets the direction in which the head segment is pointing. This is the
	 * direction formed by going from the segment behind the head segment to the
	 * head segment. A lizard that does not have more than one segment has no
	 * defined head direction and returns null.
	 * 
	 * @return the direction in which the head segment is pointing or null
	 */
	public Direction getHeadDirection() {
		Direction d = null;

		if (body.size() != 1) {
			d = getDirectionToSegmentAhead(body.get(body.size() - 2));
		}
		return d;
	}

	/**
	 * Gets the direction in which the tail segment is pointing. This is the
	 * direction formed by going from the segment ahead of the tail segment to the
	 * tail segment. A lizard that does not have more than one segment has no
	 * defined tail direction and returns null.
	 * 
	 * @return the direction in which the tail segment is pointing or null
	 */
	public Direction getTailDirection() {
		Direction d = null;

		if (body.size() != 1) {
			d = getDirectionToSegmentBehind(body.get(1));
		}
		return d;
	}

	@Override
	public String toString() {
		String result = "";
		for (BodySegment seg : getSegments()) {
			result += seg + " ";
		}
		return result;
	}
}