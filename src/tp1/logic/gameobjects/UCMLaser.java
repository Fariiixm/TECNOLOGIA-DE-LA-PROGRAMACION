package tp1.logic.gameobjects;

import tp1.logic.GameWorld;
import tp1.logic.Move;
import tp1.logic.Position;
import tp1.view.Messages;

public class UCMLaser extends UCMWeapon{

	private static final int ARMOUR = 1;
	private static final int DAMAGE = 1;
	public UCMLaser(GameWorld game, Position pos) {
		super(game, pos, ARMOUR);
		
		this.dir=Move.UP;
	}

	@Override
	public boolean isOnPosition(Position pos) {
		
		return this.pos.isOnPosition(pos);
	}
	
	public boolean isOut() {
		
		return this.pos.isOut();
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
		
		return Messages.LASER_SYMBOL;
	}

	@Override
	protected int getDamage() {
		
		return DAMAGE;
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
		
		performMovement(dir);
		if(isOut())
			die();
		
		
	}

	@Override
	protected void die() {
		
		this.life=0;
	}

	@Override
	protected void performMovement(Move dir) {
		
		this.pos.movement(dir);
	}

	@Override
	public void computerAction() {
		
		
	}

	@Override
	public boolean canShoot() {
		
		return false;
	}
}
