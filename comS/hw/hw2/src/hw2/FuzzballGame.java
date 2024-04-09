
package hw2;

/**
 * Models a simplified baseball-like game called Fuzzball.
 * 
 * @author Isaiah Aldiano
 */
public class FuzzballGame {
	/**
	 * Number of strikes causing a player to be out.
	 */
	public static final int MAX_STRIKES = 2;

	/**
	 * Number of balls causing a player to walk.
	 */
	public static final int MAX_BALLS = 5;

	/**
	 * Number of outs before the teams switch.
	 */
	public static final int MAX_OUTS = 3;

	private static final int BATTER = 2;
	private static final int NUM_BASES = 6;
	private static final int[] RESET_BASES = { 0, 0, 1, 0, 0, 0 };

	/**
	 * Players on bases
	 */
	private int[] bases = { 0, 0, 1, 0, 0, 0 };

	private int numInnings;
	private int currInning;
	private boolean topOfInning;
	private int balls;
	private int strikes;
	private int outs;
	private int team0Score;
	private int team1Score;

	public FuzzballGame(int givenNumInnings) {
		this.numInnings = givenNumInnings;
		this.currInning = 1;
		this.topOfInning = true;
		bases[BATTER] = 1;

	}

	/**
	 * VOIDS
	 */

	/**
	 * 
	 * increments current inning
	 */
	private void incCurrInning() {
		this.currInning += 1;
	}

	/**
	 * When ball is called: increments current players balls by 1. Checks if current
	 * players balls == MAX_BALLS which would initiate a walk/shift of players if
	 * need be
	 */

	public void ball() {
		if (!gameEnded()) {
			this.balls += 1;

			if (this.balls == MAX_BALLS) {
				shiftPlayersBall(BATTER);
				this.balls = 0;
				this.strikes = 0;
				return;
			}
		}
	}

	/**
	 * 
	 * @param temp
	 * @return return used for recursive functionality. Helper function to shift
	 *         players during walk. Starts at temp (batter position) on bases.
	 *         Recurses to find an open positio on bases. If open position is found
	 *         then at first base then the player is shifted to first base and
	 *         method is returned. If bases are filled then the base case shifts he
	 *         last base player off, rewarding the correct team a point, then
	 *         players are shifted to their new bases
	 */
	private int shiftPlayersBall(int temp) {
		if (temp == NUM_BASES - 1) {
			this.bases[temp] = this.bases[temp - 1];
			awardPoints(1);
		} else if (this.bases[temp] == 0) {
			this.bases[temp] = this.bases[temp - 1];
		} else if (this.bases[temp] == 1) {
			shiftPlayersBall(temp + 1);
		}

		return 0;
	}

	/**
	 * Causes batter out due to caught fly. Checks for outs and resets balls/strikes
	 */
	public void caughtFly() {
		if (!gameEnded()) {
			this.outs += 1;
			this.checkOuts();
			this.balls = 0;
			this.strikes = 0;

		}

	}

	/**
	 * 
	 * @param distance
	 * 
	 *                 Determines how bases are shifted depending on the input
	 *                 distance. If distance < 15 then the batter is fouled out If
	 *                 distance >= 15 then the player moves onto bases and shifts
	 *                 base occupiers 1, 2, or 3 bases.
	 *
	 */
	public void hit(int distance) {
		if (distance < 15 && !gameEnded()) {
			this.outs += 1;
			checkOuts();
			return;
		} else if (!gameEnded()) {
			int sum = 0;
			int offset = 0;

			if (distance >= 15 && distance < 150) {
				offset = 1;
			} else if (distance >= 150 && distance < 200) {
				offset = 2;
			} else if (distance >= 200 && distance < 250) {
				offset = 3;
			} else {
				// Home run sums players on base and adds them to the correct team
				for (int j = NUM_BASES - 1; j > BATTER; j--) {
					if (this.bases[j] == 1) {
						sum += 1;
					}
				}

				sum += 1;

				awardPoints(sum);

				return;
			}

			// Moves players based on offset
			shiftPlayersHit(offset);

			this.balls = 0;
			this.strikes = 0;
		}

	}

	/**
	 * 
	 * @param offset Helper function to shift players in case of hit. Uses offset to
	 *               look back from 3rd base to shift players to new base
	 */
	private void shiftPlayersHit(int offset) {
		for (int i = NUM_BASES - 1; i > BATTER; i--) {
			if (this.bases[i] == 1 && i + offset > NUM_BASES - 1) {
				awardPoints(1);
			}
			this.bases[i] = this.bases[i - offset];
		}
	}

	/**
	 * 
	 * @param swung Causes batter to get out immediately for swing on strike Causes
	 *              batter to accumulate strikes if no swing on strike till they
	 *              reach max strikes
	 */
	public void strike(boolean swung) {
		if (!gameEnded()) {
			if (swung) {
				this.outs += 1;
				this.balls = 0;
				this.strikes = 0;

			} else {
				this.strikes += 1;
			}

			if (this.strikes == MAX_STRIKES) {
				this.outs += 1;
				this.strikes = 0;
				this.balls = 0;
			}

			checkOuts();

		}

	}

	/**
	 * 
	 * @param points Awards points to currently batting team
	 */
	private void awardPoints(int points) {
		if (isTopOfInning()) {
			this.team0Score += points;
		} else {
			this.team1Score += points;
		}
	}

	/**
	 * Checks if outs == MAX_OUTS resets bases if teams switch due to outs ==
	 * MAX_OUTS Switches between top/bottom inning (team0/team1)
	 */
	private void checkOuts() {
		if (this.outs == MAX_OUTS) {
			this.strikes = 0;
			this.outs = 0;
			System.arraycopy(RESET_BASES, 0, bases, 0, NUM_BASES);

			if (this.topOfInning) {
				this.topOfInning = false;
			} else {
				this.topOfInning = true;
				incCurrInning();
			}
		}
	}

	/**
	 * INT
	 */

	/**
	 * 
	 * @return balls
	 */
	public int getBallCount() {
		return this.balls;
	}

	/**
	 * 
	 * @return strikes
	 */
	public int getCalledStrikes() {
		return this.strikes;
	}

	/**
	 * 
	 * @return outs
	 */
	public int getCurrentOuts() {
		return this.outs;
	}

	/**
	 * 
	 * @return team0 score
	 */
	public int getTeam0Score() {
		return this.team0Score;
	}

	/**
	 * 
	 * @return team1 score
	 */
	public int getTeam1Score() {
		return this.team1Score;
	}

	/**
	 * 
	 * @return current inning
	 */
	public int whichInning() {
		return this.currInning;
	}

	/**
	 * BOOLEAN
	 */

	/**
	 * 
	 * @return returns if top of inning or not
	 */
	public boolean isTopOfInning() {
		return this.topOfInning;
	}

	/**
	 * 
	 * @param which
	 * @return returns if referenced base is occupied
	 */
	public boolean runnerOnBase(int which) {
		return bases[which + 2] == 1;
	}

	/**
	 * @return if current inning > num innings
	 */
	public boolean gameEnded() {
		if (this.currInning > this.numInnings) {
			return true;
		}

		return false;
	}

	// TODO: EVERTHING ELSE
	// Note that this code will not compile until you have put in stubs for all
	// the required methods.

	// The methods below are provided for you and you should not modify them.
	// The compile errors will go away after you have written stubs for the
	// rest of the API methods.
	/**
	 * Returns a three-character string representing the players on base, in the
	 * order first, second, and third, where 'X' indicates a player is present and
	 * 'o' indicates no player. For example, the string "oXX" means that there are
	 * players on second and third but not on first.
	 * 
	 * @return three-character string showing players on base
	 */
	public String getBases() {
		return (runnerOnBase(1) ? "X" : "o") + (runnerOnBase(2) ? "X" : "o") + (runnerOnBase(3) ? "X" : "o");
	}

	/**
	 * Returns a one-line string representation of the current game state. The
	 * format is:
	 * 
	 * <pre>
	 *      ooo Inning:1 [T] Score:0-0 Balls:0 Strikes:0 Outs:0
	 * </pre>
	 * 
	 * The first three characters represent the players on base as returned by the
	 * <code>getBases()</code> method. The 'T' after the inning number indicates
	 * it's the top of the inning, and a 'B' would indicate the bottom. The score
	 * always shows team 0 first.
	 * 
	 * @return a single line string representation of the state of the game
	 */
	public String toString() {
		String bases = getBases();
		String topOrBottom = (isTopOfInning() ? "T" : "B");
		String fmt = "%s Inning:%d [%s] Score:%d-%d Balls:%d Strikes:%d Outs:%d";
		return String.format(fmt, bases, whichInning(), topOrBottom, getTeam0Score(), getTeam1Score(), getBallCount(),
				getCalledStrikes(), getCurrentOuts());
	}

}
