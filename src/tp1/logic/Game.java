package tp1.logic;

import java.util.Random;

import exception.InitializationException;
import exception.LaserInFlightException;
import exception.NoShockWaveException;
import exception.NotAllowedMoveException;
import exception.NotEnoughPointsException;
import tp1.control.InitialConfiguration;
import tp1.logic.gameobjects.Bomb;
import tp1.logic.gameobjects.GameObject;
import tp1.logic.gameobjects.ShockWave;
import tp1.logic.gameobjects.UCMLaser;
import tp1.logic.gameobjects.UCMShip;
import tp1.logic.gameobjects.UCMSuperLaser;
import tp1.logic.gameobjects.Ufo;
import tp1.view.Messages;


public class Game implements GameStatus, GameModel, GameWorld {

	public static final int DIM_X = 9;
	public static final int DIM_Y = 8;
	
	private GameObjectContainer container;
	private UCMShip player;
	private UCMLaser laser;
	private ShockWave shockWave;
	private int currentCycle;
	private long seed;
	private Level level;
	private AlienManager alienManager;
	private Random rand;
	private UCMSuperLaser superlaser;
	private Ufo ufo;
	
	private boolean doExit;
	

	public Game (Level level, long seed){
		
		this.level=level;
		this.seed=seed;
		
		this.doExit=false;
		initGame();
	}
		
	private void initGame(){
		this.rand=new Random(this.seed);
		this.container=new GameObjectContainer();
		this.alienManager= new AlienManager(this, level);
		
		
		this.player = new UCMShip(this, new Position(DIM_X / 2, DIM_Y - 1));
		addObject(player);
		
		GameObjectContainer container2 = null;
		try {
			container2 = alienManager.initialize(InitialConfiguration.NONE);
		} catch (InitializationException e) {
			/*porque si no tengo que hacer que el constructir Game "throws InitializationException" 
			 * ya qe dentro de su constructir esta initGame(), 
			 * y no se si esta bien*/
		}
		for (int i = 0; i < container2.size(); i++) {
			addObject(container2.getObject(i));
		}
		this.laser=new UCMLaser(this,new Position(DIM_X+1, DIM_Y+1));
		this.superlaser = new UCMSuperLaser(this,new Position(DIM_X+1, DIM_Y+1));
		
		
		this.currentCycle=0;
		
		
		this.ufo = new Ufo(this);
		shockWave = new ShockWave(this);
		
	}

	/****************************************************************/
	//GameWorld methods
	
	@Override
	public void addObject(GameObject object) {
	    this.container.add(object);
	}
	
	@Override
	public String getShockWave() {
		if(this.shockWave.canShoot() == true)return "ON";
		else
		return "OFF";
	}
	
	@Override
	public int getPlayerLife() {
		return player.getLife();
	}
	
	
	@Override
	public void addBomb(Bomb bomb) {
		this.addObject(bomb);
	}

	
	@Override
	public void attackSquare_Diagonal(Position pos) {
		this.container.attackSquare_Diagonal(pos);
		
	}
	
	@Override
	public Level getLevel() {
		return this.level;
	}
	
	@Override
	public void enableShockWave() {
		this.shockWave.enableShockWave();
	}
	
	@Override
	public void removeObject(GameObject obj) {
		this.container.remove(obj);
		
	}
	
	@Override
	public Random getRandom() {
		return rand;
	}
	
	@Override
	public boolean canGenerateRandomUfo() {
		return (getRandom().nextDouble() < getLevel().getUfoFrequency());
	}
	
	@Override
	public GameObjectContainer getContainer() {
		return this.container;
	}
	
	@Override
	public boolean isEnabledShochWave() {
		return this.shockWave.canShoot()==true;
	}
	
	/****************************************************************/
	//GameStatus methods
	@Override
	public String positionToString(int col, int row) {
		return container.toString(new Position(col, row));
	}
	
	@Override
	public String infoToString() {
		return this.container.getInfo();
	}
	
	@Override
	public String stateToString() {
		StringBuilder buffer = new StringBuilder();
		buffer.append("Life:").append(" ").append(this.getPlayerLife()).append(System.lineSeparator())
		.append("Points:").append(" ").append(receivePoints()).append(System.lineSeparator())
		.append("ShockWave:").append(" ").append(getShockWave()).append(System.lineSeparator());
		
		return buffer.toString();
	}
	
	@Override
	public boolean playerWin() {
		return this.getRemainingAliens() <= 0;
	}
	
	@Override
	public boolean aliensWin() {
		return player.isAlive() == false || this.alienManager.finalRowReached() == true;
	}
	
	@Override
	public int getCycle() {
		return this.currentCycle;
	}

	public int getRemainingAliens() {
		return this.alienManager.getRemainingAliens();
	}
	
	public boolean isFinished() {
		if(this.aliensWin()) {
			this.doExit=true;
		}
		if(this.playerWin()) {
			this.doExit = true;
		}
		return doExit;
	}
	
	@Override
	public String receivePoints() {
		// TODO Auto-generated method stub
		return Integer.toString(this.container.points());
	}
	
	
	/****************************************************************/
	//GameModel methods

	@Override
	public boolean shootSuperLaser() throws LaserInFlightException, NotEnoughPointsException{
		if(!superlaser.isAlive() || superlaser.isOut()) player.enableLaser();
		
		if(this.player.shootLaser()) {
			if(this.container.points()>4) {
		
			player.shootSuperLaser();
			this.container.decreasePointsSL();
			player.disanableLaser();
			
			return true;
			}
			else throw new NotEnoughPointsException(String.format(Messages.NOT_ENOUGH_POINTS_ERROR, this.receivePoints(), UCMSuperLaser.POINTS_REQUIRED), new Throwable());
			
		}else throw new LaserInFlightException();
		
	}
	
	@Override
	public boolean move(Move move) throws NotAllowedMoveException {
			if(player.move(move)) {
				this.update();
				return true;
			}
		return false;
	}
	
	@Override
	public void shockWave() throws NoShockWaveException {
		
			if(this.shockWave.canShoot()) {
				this.container.attackAllTable();
				shockWave.disanableShockWave();
			}else throw new NoShockWaveException(Messages.SHOCKWAVE_ERROR);
		
	}
	
	@Override
	public boolean shootLaser() throws LaserInFlightException {
		
			if(!laser.isAlive() || laser.isOut()) player.enableLaser();
			if(this.player.shootLaser()) {
				laser = player.shoot();
				player.disanableLaser();
				this.addObject(laser);
				return true;
			}else throw new LaserInFlightException();
		
	}
	
	@Override
	public void update() {
		this.currentCycle++; 
		
	    this.container.computerActions();
	    this.container.automaticMoves();
	  
	    if(canGenerateRandomUfo() && !this.container.contains(ufo)) {
	    	this.ufo= new Ufo(this);
	    	this.addObject(ufo);
	    }
	    if(this.isFinished())this.doExit=true;
	}
	
	@Override
	public void reset(InitialConfiguration conf) throws InitializationException {
		this.rand=new Random(seed);
		this.container=new GameObjectContainer();
		this.alienManager= new AlienManager(this, level);
		
		this.player = new UCMShip(this, new Position(DIM_X / 2, DIM_Y - 1));
		this.addObject(player);
		GameObjectContainer container2 = null;
		//try {
			container2 = alienManager.initialize(conf);
		//} catch (InitializationException e) {
			
			//throw new InitializationException(e.getMessage(),e);
		//}
		for (int i = 0; i < container2.size(); i++) {
			addObject(container2.getObject(i));
		}
		
		
		this.doExit=false;
		this.laser=new UCMLaser(this,new Position(DIM_X+1, DIM_Y+1));
		this.superlaser = new UCMSuperLaser(this,new Position(DIM_X+1, DIM_Y+1));
		
		
		this.currentCycle=0;
		
		
		shockWave = new ShockWave(this);
	}
	
	/*@Override
	public void reset() {
		this.rand=new Random(seed);
		this.container=new GameObjectContainer();
		this.alienManager= new AlienManager(this, level);
		
		this.player = new UCMShip(this, new Position(DIM_X / 2, DIM_Y - 1));
		addObject(player);
		
		GameObjectContainer container2 = null;
		try {
			container2 = alienManager.initialize(InitialConfiguration.NONE);
		} catch (InitializationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < container2.size(); i++) {
			addObject(container2.getObject(i));
		}
		
		this.doExit=false;
		this.laser=new UCMLaser(this,new Position(DIM_X+1, DIM_Y+1));
		this.superlaser = new UCMSuperLaser(this,new Position(DIM_X+1, DIM_Y+1));
		
		
		this.currentCycle=0;
		
		
		shockWave = new ShockWave(this);
	}*/
	
	@Override
	public void exit() {
		this.doExit=true;
	}

}
