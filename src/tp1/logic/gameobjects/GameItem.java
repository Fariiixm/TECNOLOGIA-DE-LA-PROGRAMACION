package tp1.logic.gameobjects;

import tp1.logic.Position;

public interface GameItem {
	
	
	abstract boolean performAttack(GameItem other);
	
	public boolean receiveAttack(EnemyWeapon weapon);
	public boolean receiveAttack(UCMWeapon weapon);

	public boolean isAlive();
	public boolean isOnPosition(Position pos);

	abstract void receiveDamage(int damage);

}
