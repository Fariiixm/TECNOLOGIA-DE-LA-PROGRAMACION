package tp1.logic;

/**
 * Represents the allowed movements in the game
 *
 */
public enum Move {
	LEFT(-1,0), LLEFT(-2,0), RIGHT(1,0), RRIGHT(2,0), DOWN(0,1), UP(0,-1), NONE(0,0);
	
	private int x;
	private int y;
	
	private Move(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	
	public static Move stringToMove(String dir) throws IllegalArgumentException {
	    if(dir.equalsIgnoreCase("left")) return LEFT;
	    else if(dir.equalsIgnoreCase("right")) return RIGHT;
	    else if (dir.equalsIgnoreCase("lleft")) return LLEFT;
	    else if(dir.equalsIgnoreCase("rright")) return RRIGHT;
	    else throw new IllegalArgumentException ();
	}
}