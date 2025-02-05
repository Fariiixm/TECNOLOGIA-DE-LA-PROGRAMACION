package tp1.logic;

import java.util.Random;

import tp1.logic.gameobjects.Bomb;
import tp1.logic.gameobjects.GameObject;

public interface GameWorld {
	
	
	public void addObject(GameObject object);
	public String getShockWave();
	public int getPlayerLife();
	public void addBomb(Bomb bomb);

	public void attackSquare_Diagonal(Position pos);
	public int getCycle();
	public Level getLevel();
	public void enableShockWave();
	public void removeObject(GameObject obj);
	public Random getRandom();
	public boolean canGenerateRandomUfo();
	public GameObjectContainer getContainer();
	public boolean isEnabledShochWave();
	public void exit();
	public void update();
	

}
