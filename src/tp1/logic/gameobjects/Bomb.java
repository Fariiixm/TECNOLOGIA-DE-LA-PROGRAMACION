package tp1.logic.gameobjects;


import tp1.logic.GameWorld;
import tp1.logic.Move;
import tp1.logic.Position;
import tp1.view.Messages;

public class Bomb extends EnemyWeapon {

	private static final int ARMOUR = 1;
	private static final int DAMAGE = 1;
	private DestroyerAlien owner;
	public Bomb(GameWorld game, Position posi, DestroyerAlien owner) {
		super(game, posi, ARMOUR);
	
		this.pos = posi;
		this.dir=Move.DOWN;
		this.owner=owner;
	}

	@Override
	public boolean isOnPosition(Position pos) {
		return this.pos.isOnPosition(pos);
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
		return Messages.BOMB_SYMBOL;
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

	private boolean isOut() {
		return pos.isOut();
	}

	@Override
	protected void performMovement(Move dir) {
		this.pos.movement(dir);
	}

	@Override
	protected void die() {
		this.life=0;
		owner.enableBomb();
	}

	@Override
	public void computerAction() {
		
	}

	@Override
	public boolean canShoot() {
		return false;
	}
	
	@Override
	public boolean performAttack(GameItem other) {
		
		if(this.isAlive() && other.isAlive() && other.isOnPosition(pos)) {
			boolean attackPerformed = weaponAttack(other);
			if(attackPerformed) {
				this.die();
				owner.enableBomb();
			}
			return attackPerformed;
		}
		return false;
	}
}
