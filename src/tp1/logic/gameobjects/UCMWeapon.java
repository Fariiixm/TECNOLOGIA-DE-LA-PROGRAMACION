package tp1.logic.gameobjects;

import tp1.logic.GameWorld;
import tp1.logic.Position;

public class UCMWeapon extends Weapon{

	public UCMWeapon(GameWorld game, Position pos, int armour) {
		
		super(game, pos, armour);
	}
	
	@Override
	public boolean weaponAttack(GameItem other) {
		
		return other.receiveAttack(this);
	}

	@Override
	public boolean receiveAttack(EnemyWeapon weapon) {
		life -=weapon.getDamage();
		if(!this.isAlive()) {
			this.die();
		}
		return true;
	}

}
