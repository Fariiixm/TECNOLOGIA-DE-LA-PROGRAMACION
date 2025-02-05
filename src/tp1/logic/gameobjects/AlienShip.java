package tp1.logic.gameobjects;

import tp1.logic.AlienManager;
import tp1.logic.GameWorld;
import tp1.logic.Move;
import tp1.logic.Position;

public class AlienShip extends EnemyShip{

	private int cyclesToMove;
	private AlienManager alienManager;
	
	public AlienShip(GameWorld game, Position pos, int armour, AlienManager alienManager) {
		
		super(game, pos, armour);
		this.cyclesToMove = 0;
		this.alienManager=alienManager;
	}
	
	public AlienShip() {
	
		super();
	}
	@Override
	public void automaticMove() {
		this.cyclesToMove++;
		if (this.alienManager.getCyclesToDescend() == this.game.getCycle()) {
			descent();
			changeDir();
			isInFinalRow();
			this.cyclesToMove--;
		}else if (cyclesToMove % (this.game.getLevel().getNumCyclesToMoveOneCell() + 1) == 0) {
			performMovement(dir);
			if(isInFinalColumn(pos)) {
				this.alienManager.setCyclesToDescend(this.game.getCycle() + 1);
			}
		}
	}

	private void descent() {
		performMovement(Move.DOWN);
	}
	
	private void changeDir() {
		if(dir == Move.LEFT)dir = Move.RIGHT;
		else dir = Move.LEFT;
	}
	
	private boolean isInFinalColumn(Position pos) {
		
		return pos.isInFinalColumn();
	}
	
	public void isInFinalRow() {
		
	}

	protected AlienShip copy(GameWorld game, Position pos, AlienManager am) {
		
		return null;
	}

	
	

}
