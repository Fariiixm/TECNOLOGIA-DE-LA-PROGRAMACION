package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.logic.GameWorld;
import tp1.logic.Move;
import tp1.logic.Position;
import tp1.view.Messages;

public class Ufo extends EnemyShip {

	private static final int ARMOUR = 1;
	
	//No es final porque elimino a ufo, y en container tengo que si la vida del objeto es 0, sume sus puntos.
	//y me lo cuenta como que lo he matado con el laser.
	//private  static final int POINTS = 25;
	private int puntos;
	
	
	private boolean enabled;
	public Ufo(GameWorld game) {
		super(game, new Position(Game.DIM_X-1,0), ARMOUR);
		
		this.enabled=false;
		this.dir=Move.LEFT;
		this.puntos=0;
	}

	@Override
	public boolean isOnPosition(Position pos) {
		
		return this.pos.isOnPosition(pos);
	}

	@Override
	protected String getSymbol() {
		
		return Messages.UFO_SYMBOL; 
	}

	@Override
	protected int getDamage() {
		
		return 0;
	}
	
	@Override
	public boolean receiveAttack(UCMWeapon weapon) {
		life -=weapon.getDamage();
		if(!this.isAlive()) {
			this.die();
		}
		return true;
	}

	@Override
	protected int getArmour() {
		
		return ARMOUR;
	}

	@Override
	public void onDelete() {
		

	}

	@Override
	public void automaticMove() {
		
			this.performMovement(dir);
	}

	@Override
	public String toString() {
		
		return String.format(Messages.GAME_OBJECT_STATUS, this.getSymbol(), getLife());
	}

	@Override
	public String getInfo() {
		
		return this.getDescription();
	}

	@Override
	protected String getDescription() {
		
		return String.format(Messages.ALIEN_DESCRIPTION,Messages.UFO_DESCRIPTION, 25, getDamage(), getArmour());
	}

	@Override
	public int getKillPoints() {
		
		return puntos;//POINTS;
	}

	@Override
	protected void performMovement(Move dir) {
		
		
		this.pos.movement(dir);
	}

	@Override
	protected void die() {
		
		this.life=0;
		game.enableShockWave();
		this.puntos=25;
	}

	@Override
	public void computerAction() {
		
		this.isOut();
	}

	
	public boolean isEnabled() {
		return enabled;
	}

	private boolean isOut() {
		
		
		if(this.pos.isOut()) {
			
			this.game.removeObject(this);
			return true;
		}
		
		return false;
	}

	@Override
	public boolean canShoot() {
		
		return false;
	}
	
	public void receiveDamage() {
		
	}

	public void dianable() {
		
		this.enabled=false;
	}

}
