package server.model;

/**
* Model containing the special bonuses.
* It's a matrix that contains the integer value of that bonus.
* The bonuses are Regular (no bonus), Double letter, Triple letter,
* Double word and triple word.
* @author Bernard <bernard.debecker@gmail.com>
*/
public class ScoringGrid {

		public static final int REGULAR = 0;
		public static final int DOUBLE_LETTER = 1;
		public static final int TRIPLE_LETTER = 2;
		public static final int DOUBLE_WORD = 3;
		public static final int TRIPLE_WORD = 4;
		
		/**
			* The matrix that contains the bonuses
			*/
		private static final int[][] scoringGrid = {
				{TRIPLE_WORD,REGULAR,REGULAR,DOUBLE_LETTER,REGULAR,REGULAR,REGULAR,TRIPLE_WORD,REGULAR,REGULAR,REGULAR,DOUBLE_LETTER,REGULAR,REGULAR,TRIPLE_WORD},
				{REGULAR,DOUBLE_WORD,REGULAR,REGULAR,REGULAR,TRIPLE_LETTER,REGULAR,REGULAR,REGULAR,TRIPLE_LETTER,REGULAR,REGULAR,REGULAR,DOUBLE_WORD,REGULAR},
				{REGULAR,REGULAR,DOUBLE_WORD,REGULAR,REGULAR,REGULAR,DOUBLE_LETTER,REGULAR,DOUBLE_LETTER,REGULAR,REGULAR,REGULAR,DOUBLE_WORD,REGULAR,REGULAR},
				{DOUBLE_LETTER,REGULAR,REGULAR,DOUBLE_WORD,REGULAR,REGULAR,REGULAR,DOUBLE_LETTER,REGULAR,REGULAR,REGULAR,DOUBLE_WORD,REGULAR,REGULAR,TRIPLE_WORD},
				{REGULAR,REGULAR,REGULAR,REGULAR,DOUBLE_WORD,REGULAR,REGULAR,REGULAR,REGULAR,REGULAR,DOUBLE_WORD,REGULAR,REGULAR,REGULAR,REGULAR},
				{REGULAR,TRIPLE_LETTER,REGULAR,REGULAR,REGULAR,TRIPLE_LETTER,REGULAR,REGULAR,REGULAR,TRIPLE_LETTER,REGULAR,REGULAR,REGULAR,TRIPLE_LETTER,REGULAR},
				{REGULAR,REGULAR,DOUBLE_LETTER,REGULAR,REGULAR,REGULAR,DOUBLE_LETTER,REGULAR,DOUBLE_LETTER,REGULAR,REGULAR,REGULAR,DOUBLE_LETTER,REGULAR,REGULAR},
				{TRIPLE_WORD,REGULAR,REGULAR,DOUBLE_LETTER,REGULAR,REGULAR,REGULAR,DOUBLE_WORD,REGULAR,REGULAR,REGULAR,DOUBLE_LETTER,REGULAR,REGULAR,TRIPLE_WORD},
				{REGULAR,REGULAR,DOUBLE_LETTER,REGULAR,REGULAR,REGULAR,DOUBLE_LETTER,REGULAR,DOUBLE_LETTER,REGULAR,REGULAR,REGULAR,DOUBLE_LETTER,REGULAR,REGULAR},
				{REGULAR,TRIPLE_LETTER,REGULAR,REGULAR,REGULAR,TRIPLE_LETTER,REGULAR,REGULAR,REGULAR,TRIPLE_LETTER,REGULAR,REGULAR,REGULAR,TRIPLE_LETTER,REGULAR},
				{REGULAR,REGULAR,REGULAR,REGULAR,DOUBLE_WORD,REGULAR,REGULAR,REGULAR,REGULAR,REGULAR,DOUBLE_WORD,REGULAR,REGULAR,REGULAR,REGULAR},
				{DOUBLE_LETTER,REGULAR,REGULAR,DOUBLE_WORD,REGULAR,REGULAR,REGULAR,DOUBLE_LETTER,REGULAR,REGULAR,REGULAR,DOUBLE_WORD,REGULAR,REGULAR,TRIPLE_WORD},
				{REGULAR,REGULAR,DOUBLE_WORD,REGULAR,REGULAR,REGULAR,DOUBLE_LETTER,REGULAR,DOUBLE_LETTER,REGULAR,REGULAR,REGULAR,DOUBLE_WORD,REGULAR,REGULAR},
				{REGULAR,DOUBLE_WORD,REGULAR,REGULAR,REGULAR,TRIPLE_LETTER,REGULAR,REGULAR,REGULAR,TRIPLE_LETTER,REGULAR,REGULAR,REGULAR,DOUBLE_WORD,REGULAR},
				{TRIPLE_WORD,REGULAR,REGULAR,DOUBLE_LETTER,REGULAR,REGULAR,REGULAR,TRIPLE_WORD,REGULAR,REGULAR,REGULAR,DOUBLE_LETTER,REGULAR,REGULAR,TRIPLE_WORD},
		};

		/**
			* Get the bonus from that square
			* @param x the x coordinate
			* @param y the y coordinate
			* @return the bonus as an integer
			*/
		public int getBonus(int x, int y) {
				return scoringGrid[x][y];
		}
		
		public void checkBonus(int x, int y, int val, boolean wd, boolean wt, int cScore) {
				switch(getBonus(x, y)) {
						case 4:
								wd = true;
								break;
						case 5:
								wt = true;
								break;
						default:
								cScore += val*getBonus(x, y);
				}
		}
}