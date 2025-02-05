package tp1.logic.gameobjects;

import tp1.logic.GameWorld;
import tp1.logic.Move;
import tp1.logic.Position;

public class Ship extends GameObject{

	public Ship(GameWorld game, Position pos, int armour) {
	
		super(game, pos, armour);
	}

	public Ship() {
		
		super();
	}

	@Override
	public String toString() {
		
		return null;
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
		
		return null;
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
	public void computerAction() {
		
		
	}

	@Override
	protected void performMovement(Move dir) {
		this.pos.movement(dir);
	}

	@Override
	protected void die() {
		
	}

	@Override
	public boolean canShoot() {
		return false;
	}

	@Override
	protected int getDamage() {
		return 0;
	}

	@Override
	protected boolean weaponAttack(GameItem other) {
		return false;
	}

	@Override
	public boolean isOnPosition(Position pos) {
		return false;
	}

	@Override
	public boolean receiveAttack(EnemyWeapon weapon) {
		
		return false;
	}

	@Override
	public boolean receiveAttack(UCMWeapon weapon) {
		
		return false;
	}

	@Override
	public void receiveDamage(int damage) {
		
		
	}


}
