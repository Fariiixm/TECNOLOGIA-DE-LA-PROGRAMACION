package tp1.logic.gameobjects;

import tp1.logic.GameWorld;
import tp1.logic.Position;

public class EnemyWeapon extends Weapon{

	public EnemyWeapon(GameWorld game, Position pos, int life) {
		super(game, pos, life);
	}
	
	@Override
	public boolean weaponAttack(GameItem other) {
		return other.receiveAttack(this);
	}
	
	@Override
	public boolean receiveAttack(UCMWeapon weapon) {
		life -=weapon.getDamage();
		if(!this.isAlive()) {
			this.die();
		}
		return true;
	}
}
