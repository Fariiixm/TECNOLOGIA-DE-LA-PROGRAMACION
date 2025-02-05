package tp1.logic;

import exception.NotAllowedMoveException;
import exception.OffWorldException;
import tp1.logic.gameobjects.GameItem;
import tp1.view.Messages;

/**
 * 
 * Immutable class to encapsulate and manipulate positions in the game board
 * 
 */
public class Position {

	private int col;
	private int row;
	
	public Position(int col, int row) {
		this.col=col;
		this.row=row;
	}
	
	public Position() {
		
	}

	public Position(Position pos) {
		this.col = pos.col;
		this.col = pos.row;
	}

	public boolean isOut() {
		
		return this.row>Game.DIM_Y-1 || this.row < 0 || this.col>Game.DIM_X-1 || col < -1|| this.col<0;
	}
	
	public int getCol() {
		return this.col;
		
	}
	
	public int getRow() {
		return this.row;
	}
	
	public void move(int dir) {
		col+=dir;
		if(col <0)col=0;
		if(col>Game.DIM_X)col=Game.DIM_Y;
	}
	
	public void movement(Move move) {
		col+=move.getX();
    	row+=move.getY();
	}
	
	public boolean movementPlayer(Move move) throws NotAllowedMoveException{
		col+=move.getX();
    	row+=move.getY();
    	if(this.isOut()) {
    		col-=move.getX();
        	row-=move.getY();
        	//throw new OffWorldException(String.format(Messages.OFF_WORLD_MESSAGE, move.toString(),String.format(Messages.POSITION, col,row )));
        	throw new NotAllowedMoveException(String.format(Messages.OFF_WORLD_MESSAGE, move.toString(), String.format(Messages.POSITION, col, row)), new Throwable());
    	}
    	return true;
	}
	
	public boolean isOnPosition(Position pos) {
		
		if(pos.getCol()== this.col && pos.getRow() == this.getRow())return true;
		else
		
		return false;
	}

	/*public void descent() {
		
		if(col>Game.DIM_X - 1) {
			col = 0;
			this.movement(Move.LEFT);
		}
		else if(col<0) {
			col = 7;
			this.movement(Move.RIGHT);
		}
	}*/

	public boolean isInFinalColumn() {
		
		return col == Game.DIM_X - 1 || col == 0;
	}

	public boolean isInFinalRow() {
		return this.row == Game.DIM_Y-1;
	}

	public boolean isOutExp() throws OffWorldException {
		if(this.row>Game.DIM_Y-1 || this.row < 0 || this.col>Game.DIM_X-1 || this.col<0) throw new OffWorldException(String.format(Messages.OFF_WORLD_POSITION, String.format(Messages.POSITION, col, row)), new Throwable());
		return false;
	}

	public boolean Square(GameItem other) {
		for(int i = col-1; i <= col+1; i++) {
			for(int j = row-1; j <= row + 1; j++) {
				if(other.isOnPosition(new Position(i,j)) && !this.isOnPosition(new Position(i,j))) {
					return true;
				}
			}
		}
		return false;
	}
}
	