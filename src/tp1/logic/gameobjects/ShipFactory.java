package tp1.logic.gameobjects;

import java.util.Arrays;
import java.util.List;

import exception.InitializationException;
import exception.OffWorldException;
import tp1.logic.AlienManager;
import tp1.logic.GameWorld;
import tp1.logic.Position;
import tp1.view.Messages;

public class ShipFactory {
	
	 private static final List<AlienShip> AVAILABLE_ALIEN_SHIPS = Arrays.asList(new RegularAlien(), new DestroyerAlien(), new ExplosiveAlien());
	
	 public static AlienShip spawnAlienShip(String input, GameWorld game, Position pos, AlienManager am) throws InitializationException, OffWorldException{
	        for (AlienShip ship : AVAILABLE_ALIEN_SHIPS) {
	            if (ship.getSymbol().toLowerCase().equalsIgnoreCase(input)) {
	                //try {
	                	pos.isOutExp();
	            		return ship.copy(game, pos, am);
	               // }catch(OffWorldException e) {
	                //	throw new OffWorldException(e.getMessage(),e);
	                //}  
	            }
	        }
	        throw new InitializationException(String.format(Messages.UNKNOWN_SHIP,input), new Throwable());
	      
	    }

}
