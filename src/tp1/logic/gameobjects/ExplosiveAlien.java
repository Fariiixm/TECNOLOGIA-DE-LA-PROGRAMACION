package tp1.logic.gameobjects;

import tp1.logic.AlienManager;
import tp1.logic.GameWorld;
import tp1.logic.Move;
import tp1.logic.Position;
import tp1.view.Messages;

public class ExplosiveAlien extends AlienShip {

	private static final int ARMOUR = 2;
	private static final int POINTS = 12;
	private static final int DAMAGE = 1;
	private AlienManager alienManager;

	public ExplosiveAlien(GameWorld game, Position pos, AlienManager alienManager) {
		super(game, pos,ARMOUR, alienManager);
		this.dir=Move.LEFT;
		this.alienManager=alienManager;
		
	}

	public ExplosiveAlien() {
		super();
	}
	
	@Override
	 protected AlienShip copy(GameWorld game, Position pos,AlienManager am) {
		 return new ExplosiveAlien(game, pos, am);
	 }
	
	@Override
	public boolean isOnPosition(Position pos) {
		return this.pos.isOnPosition(pos);
	}

	@Override
	protected String getSymbol() {
		return Messages.EXPLOSIVE_ALIEN_SYMBOL;
	}
	
	@Override
	protected int getArmour() {
		return ARMOUR;
	}
	
	@Override
	public String getInfo() {
		return getDescription();
	}

	@Override
	protected String getDescription() {
		return String.format(Messages.ALIEN_DESCRIPTION,Messages.EXPLOSIVE_ALIEN_DESCRIPTION, getKillPoints(), this.getDamage(), getArmour());
	}
	
	@Override
	public String toString() {
		return String.format(Messages.GAME_OBJECT_STATUS, this.getSymbol(), getLife());
	}
	
	@Override
	public int getDamage() {
		return DAMAGE;
	}
	
	@Override
	public int getKillPoints() {
		return POINTS;
	}
	
	@Override
	protected void die() {
		this.life=0;
		this.alienManager.decreasRemaniningAliens();
		this.game.attackSquare_Diagonal(/*this.getPosition()*/this.pos);
	}
}
