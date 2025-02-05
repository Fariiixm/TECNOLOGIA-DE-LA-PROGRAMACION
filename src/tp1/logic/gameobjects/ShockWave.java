package tp1.logic.gameobjects;

import tp1.logic.GameWorld;
import tp1.logic.Move;
import tp1.logic.Position;
import tp1.view.Messages;

public class ShockWave extends UCMWeapon{

	private boolean canShoot;
	private static final int DAMAGE = 1;
	
	public ShockWave(GameWorld game) {
		super(game, null, 0);
		this.canShoot = false;
		
	}

	@Override
	public boolean isOnPosition(Position pos) {
		
		return false;
	}

	@Override
	public String toString() {
		
		return getSymbol();
	}

	@Override
	public String getInfo() {
		
		return null;
	}

	@Override
	protected String getDescription() {
		
		return null;
	}

	@Override
	protected String getSymbol() {
		
		return Messages.SHOCKWAVE_SYMBOL;
	}

	@Override
	protected int getDamage() {
		
		return DAMAGE;
	}

	@Override
	protected int getArmour() {
		
		return 0;
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

	@Override
	protected void die() {
		
		
	}

	@Override
	public void computerAction() {
		
		
	}

	@Override
	public boolean canShoot() {
		
		return canShoot;
	}
	
	public void disanableShockWave() {
		this.canShoot=false;
	}
	
	public void enableShockWave() {
		this.canShoot=true;
	}
	@Override
	public boolean performAttack(GameItem other) {
		if(this.canShoot)
		other.receiveDamage(DAMAGE);
		return true;
	}
}
