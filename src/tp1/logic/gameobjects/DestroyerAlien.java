package tp1.logic.gameobjects;

import tp1.logic.AlienManager;
import tp1.logic.Game;
import tp1.logic.GameWorld;
import tp1.logic.Move;
import tp1.logic.Position;
import tp1.view.Messages;

public class DestroyerAlien extends AlienShip {

	
	private boolean shootBomb;
	private static final int ARMOUR = 1;
	private static final int POINTS = 10;
	private static final int DAMAGE = 1;
	private AlienManager alienManager;
	public DestroyerAlien(GameWorld game, Position pos, AlienManager alienManager) {
		super(game, pos, ARMOUR, alienManager);
		this.life=ARMOUR;
		this.dir=Move.LEFT;
		this.shootBomb=true;
		this.alienManager=alienManager;
		
	
	}

	public DestroyerAlien() {
		
		super();
	}

	@Override
	 protected AlienShip copy(GameWorld game, Position pos,AlienManager am) {
	 
		 return new DestroyerAlien(game, pos, am);
	 }
	
	@Override
	protected String getSymbol() {
		
		return Messages.DESTROYER_ALIEN_SYMBOL;
	}

	@Override
	public int getKillPoints(){
		
		return POINTS;
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
		
		return this.getDescription();
	}

	@Override
	protected String getDescription() {
		
		return String.format(Messages.ALIEN_DESCRIPTION,Messages.DESTROYER_ALIEN_DESCRIPTION, getKillPoints(), getDamage(),getArmour());
	}

	@Override
	protected int getDamage() {
		
		return DAMAGE;
	}

	@Override
	protected void die() {
		
		this.life=0;
		this.alienManager.decreasRemaniningAliens();		
	}

	@Override
	public void computerAction() {
		
		if (game.getCycle() % (game.getLevel().getNumCyclesToMoveOneCell() + 1) != 0) {
			if(this.shootBomb) {
				if(this.canGenerateRandomBomb()){
					Position p  = new Position(this.getCol(), this.getRow());
					this.game.addBomb(new Bomb(this.game, p, this));
					disanableBomb();
				
				}
			}
		}
		
	}
	

	private void disanableBomb() {
		
		this.shootBomb=false;
	}

	private boolean canGenerateRandomBomb() {
		
		return (game.getRandom().nextDouble() < game.getLevel().getShootFrequency());
	}

	@Override
	public boolean canShoot() {
		
		return false;
	}

	@Override
	public boolean isOnPosition(Position pos) {
	
		return this.pos.isOnPosition(pos);
	}

	private int getCol() {
		
		return this.pos.getCol();
	}

	private int getRow() {
		
		return this.pos.getRow();
	}

	public void enableBomb() {
		
		this.shootBomb=true;
	}
	
	@Override
	public void isInFinalRow() {
		if(this.pos.getRow() == Game.DIM_Y-1) {
			alienManager.isFinalRow();
		}
	}
	
	
}
