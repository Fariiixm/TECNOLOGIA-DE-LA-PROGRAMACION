package tp1.logic.gameobjects;

import tp1.logic.AlienManager;
import tp1.logic.GameWorld;
import tp1.logic.Move;
import tp1.logic.Position;
import tp1.view.Messages;

public class RegularAlien extends AlienShip {
	
	
	private static final int ARMOUR = 2;
	private static final int POINTS = 5;
	private AlienManager alienManager;

	public RegularAlien(GameWorld game, Position pos, AlienManager alienManager) {
		super(game, pos, ARMOUR, alienManager);
		this.dir=Move.LEFT;
		this.alienManager=alienManager;
		
	}

	public RegularAlien() {
		super();
		
	}


	@Override
	public boolean isOnPosition(Position pos) {
		return this.pos.isOnPosition(pos);
	}

	@Override
	protected String getSymbol() {
		
		return Messages.REGULAR_ALIEN_SYMBOL;
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
	public void onDelete() {
		

	}

	@Override
	public String toString() {
		
		return String.format(Messages.GAME_OBJECT_STATUS, getSymbol(), getLife());
	}

	@Override
	public String getInfo() {
		
		return getDescription();
	}

	@Override
	protected String getDescription() {
		
		return String.format(Messages.ALIEN_DESCRIPTION,Messages.REGULAR_ALIEN_DESCRIPTION, getKillPoints(), getDamage(), getArmour());
	}

	@Override
	public int getKillPoints() {
		
		return POINTS;
	}

	@Override
	protected void die() {
		
		this.life=0;
		this.alienManager.decreasRemaniningAliens();
	}

	@Override
	public void computerAction() {
		
		
	}

	@Override
	public boolean canShoot() {
		
		return false;
	}
	
	@Override
	public void isInFinalRow() {
		if(this.pos.isInFinalRow()) {
			alienManager.isFinalRow();
		}
	}
	
	 @Override
	 protected AlienShip copy(GameWorld game, Position pos,AlienManager am) {
	 
		 return new RegularAlien(game, pos, am);
	 }
	 
	 

}
