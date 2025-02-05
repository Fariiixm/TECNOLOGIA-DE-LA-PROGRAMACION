package tp1.logic;

import exception.InitializationException;
import exception.LaserInFlightException;
import exception.NoShockWaveException;
import exception.NotAllowedMoveException;
import exception.NotEnoughPointsException;
import exception.OffWorldException;
import tp1.control.InitialConfiguration;

public interface GameModel {

	public void update();
	public void reset(InitialConfiguration conf) throws InitializationException, OffWorldException;
	public void exit();
	public boolean move(Move move) throws NotAllowedMoveException;
	public boolean shootLaser() throws LaserInFlightException;
	public void shockWave() throws NoShockWaveException;
	public String infoToString();
	public boolean shootSuperLaser() throws LaserInFlightException, NotEnoughPointsException;
	}
