package tp1.logic.gameobjects;

import exception.NotAllowedMoveException;
import tp1.logic.Game;
import tp1.logic.Move;
import tp1.logic.Position;
import tp1.view.Messages;

public class UCMShip extends Ship{

	
	private static final int ARMOUR = 3;
	private boolean canShoot;
	
	public UCMShip(Game game, Position pos) {
		
		super(game, pos, ARMOUR);
		this.canShoot=true;
		
	}

	@Override
	public boolean isOnPosition(Position pos) {
		
		return this.pos.isOnPosition(pos);
	}

	@Override
	public String toString() {
		
		return getSymbol();
	}

	@Override
	public String getInfo() {
		
		return getDescription();
	}

	@Override
	protected String getDescription() {
		
		return String.format(Messages.UCM_DESCRIPTION, Messages.UCMSHIP_DESCRIPTION, 1,getArmour());
	}

	@Override
	protected String getSymbol() {
		
		if(isAlive())return Messages.UCMSHIP_SYMBOL;
		return Messages.UCMSHIP_DEAD_SYMBOL;
	}

	@Override
	protected int getDamage() {
		
		return 0;
	}

	@Override
	protected int getArmour() {
		
		return ARMOUR;
	}

	@Override
	public int getKillPoints() {
		
		return 0;
	}

	@Override
	public void onDelete() {
		
		
	}

	@Override
	public void automaticMove() {
		
		
	}

	@Override
	protected void performMovement(Move dir) {
		
		
	}
	
	public boolean  move(Move move) throws NotAllowedMoveException  {		
		
		pos.movementPlayer(move);
    	return true;
    }

	@Override
	protected void die() {
		
	}

	public boolean shootLaser() {
		
		return canShoot;
	}

	@Override
	public void computerAction() {
		
	}

	@Override
	public boolean canShoot() {
		return false;
	}

	public void enableLaser() {
		this.canShoot=true;
	}

	public void disanableLaser() {
		this.canShoot=false;
	}
	
	public boolean receiveAttack(EnemyWeapon weapon) {
		life -=weapon.getDamage();
		if(!this.isAlive()) {
			this.die();
		}
		return true;
	}

	public static String allowedMoves(String separator) {
	    StringBuilder moves = new StringBuilder();
	    int count = 0;
	    for (Move move : Move.values()) {
	        
	        if (move == Move.LEFT || move == Move.LLEFT || move == Move.RIGHT || move == Move.RRIGHT) {
	            moves.append(move.name().toLowerCase());
	            count++;
	            
	            if (count < 4) {
	                moves.append(separator);
	            }
	        }
	    }
	    return moves.toString();
	}

	public UCMLaser shoot() {
		
		Position pos = new Position(this.getCol(), this.getRow());
		return new UCMLaser(game,pos);
		
		
		
	}

	private int getRow() {
	
		return this.pos.getRow();
	}

	private int getCol() {
		
		return this.pos.getCol();
	}

	public void shootSuperLaser() {
		Position pos = new Position(this.getCol(), this.getRow());
		game.addObject(new UCMSuperLaser(game, pos));
		
	}
	
}
