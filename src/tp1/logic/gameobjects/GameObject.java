package tp1.logic.gameobjects;

import tp1.logic.GameWorld;
import tp1.logic.Move;
import tp1.logic.Position;

public abstract class GameObject implements GameItem {

	protected Position pos;
	protected int life;
	protected GameWorld game;
	protected Move dir;
	
	
	public GameObject(GameWorld game, Position pos, int life) {	
		this.pos = pos;
		this.game = game;
		this.life = life;
	}
	
	public GameObject() {
		
	}

	@Override
	public boolean isAlive() {
		return this.life > 0;
	}

	public int getLife() {
		return this.life;
	}

	public abstract String toString();
	public abstract String getInfo();
	
	protected abstract String getDescription();
	protected abstract String getSymbol();
	protected abstract int getDamage();
	protected abstract int getArmour();
	public abstract int getKillPoints();
	
		
	public abstract void onDelete();
	public abstract void automaticMove();
	public abstract void computerAction();
	
	protected abstract void performMovement(Move dir);
	protected abstract void die();
	public abstract boolean canShoot();
	public abstract boolean isOnPosition(Position pos);
	
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
	
	protected abstract boolean weaponAttack(GameItem other);

	public void receiveDamage() {
		
	}

}
