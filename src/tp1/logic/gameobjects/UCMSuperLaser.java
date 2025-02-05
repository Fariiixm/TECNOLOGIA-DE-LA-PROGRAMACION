package tp1.logic.gameobjects;

import tp1.logic.GameWorld;
import tp1.logic.Position;
import tp1.view.Messages;

public class UCMSuperLaser extends UCMLaser{

	public static final int POINTS_REQUIRED = 5;
	public static final int DAMAGE = 2;
	public UCMSuperLaser(GameWorld game, Position pos) {
		super(game, pos);
		
	}

	@Override
	protected String getSymbol() {
		
		return Messages.SUPERLASER_SYMBOL;
	}
	
	@Override
	public String toString() {
		
		return getSymbol();
	}
	
	@Override
	public boolean performAttack(GameItem other) {
		
		if(this.isAlive() && other.isAlive() && other.isOnPosition(this.pos)) {
			boolean attackPerformed = weaponAttack(other);
			if(attackPerformed) {
				this.die();
			}
			return attackPerformed;
		}
		return false;
	}
	
	@Override
	protected int getDamage() {
		
		return DAMAGE;
	}
}
