package tp1.logic.gameobjects;

import tp1.logic.GameWorld;
import tp1.logic.Position;

public class EnemyShip extends Ship{

	public EnemyShip(GameWorld game, Position pos, int armour) {
		super(game, pos, armour);
	}
	
	public EnemyShip() {
		super();
		}

	@Override
	public boolean receiveAttack(UCMWeapon weapon) {
		life -=weapon.getDamage();
		if(!this.isAlive()) {
			this.die();
		}
		return true;
	}
	public void receiveDamage() {
		this.life--;
		if(!this.isAlive())die();
	}

}
