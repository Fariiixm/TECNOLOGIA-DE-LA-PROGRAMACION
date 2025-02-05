package tp1.logic;


import exception.InitializationException;
import exception.OffWorldException;
import tp1.control.InitialConfiguration;
import tp1.logic.gameobjects.AlienShip;
import tp1.logic.gameobjects.DestroyerAlien;
import tp1.logic.gameobjects.RegularAlien;
import tp1.logic.gameobjects.ShipFactory;
import tp1.view.Messages;

public class AlienManager  {
	
	private Game game;
	private int remainingAliens;
	private Level level;
	private boolean descent;
	private int CyclesToDescend;
	private boolean endRow;
	
	public AlienManager(Game game, Level level) {
		//this.remainingAliens=0;
		this.game=game;
		this.level=level;
		this.descent=false;
		this.CyclesToDescend=-3;//0;
		this.endRow=false;
	}
	
	private void costumedInitialization(GameObjectContainer container, InitialConfiguration conf) throws InitializationException{
	    
	        for (String shipDescription : conf.getShipDescription()) {
	            String[] words = shipDescription.toLowerCase().trim().split("\\s+");
	           try {
	        	   if(words.length != 3) {
	        		   throw new InitializationException( String.format(Messages.INCORRECT_ENTRY, shipDescription), new Throwable());
	        	   } else {
	                AlienShip ship = ShipFactory.spawnAlienShip(words[0], this.game, new Position(Integer.parseInt(words[1]), Integer.parseInt(words[2])), this);
	                container.add(ship);
	                this.remainingAliens++;
	        	   }
	           	}catch(InitializationException  | OffWorldException e) {
	   	        	throw new InitializationException(e.getMessage(), e);
	   	    	}catch(NumberFormatException nfe) {
	   	    		
	   	    		throw new InitializationException(String.format(Messages.INVALID_POSITION, words[1],words[2]), new Throwable());
	   	    	}
	        }
	    
	}

	public GameObjectContainer initialize(InitialConfiguration conf) throws InitializationException	{
		this.remainingAliens = 0;
		GameObjectContainer container = new GameObjectContainer();
		if(conf == InitialConfiguration.NONE) {
			
			initializeDestroyerAliens(container);
			initializeRegularAliens(container);
		}else {
			this.costumedInitialization(container, conf);
		}
		
		
		
		return container;
	}
	
	private void initializeRegularAliens (GameObjectContainer container) {
		
		int empezar=(Game.DIM_X/2)-(this.level.getNumRegularAliens()/(2*this.level.NumRowsRegularAliens()));
		Position pos;
		
			for (int j = 0; j < this.level.NumRowsRegularAliens(); j++) {
				for (int i = 0; i < (this.level.getNumRegularAliens()/this.level.NumRowsRegularAliens()); i++) {
					pos = new Position(empezar + i, j + 1);
					container.add(new RegularAlien(game, pos, this));
					this.remainingAliens++;

				}
			}
	}
	
	private void initializeDestroyerAliens(GameObjectContainer container) {
		//TODO fill with your code
		int empieza_colocacion = (Game.DIM_X / 2) - (this.level.getNumDestroyerAliens() / 2);
		Position pos;
		for (int i = 0; i < this.level.getNumDestroyerAliens(); i++) {
			pos = new Position(empieza_colocacion + i, this.level.NumRowsRegularAliens() + 1); 
			container.add(new DestroyerAlien(game, pos, this));
			this.remainingAliens++;
		}
	}

	public int getRemainingAliens() {
		// TODO Auto-generated method stub
		return this.remainingAliens;
	}


	public boolean canDescend() {
		// TODO Auto-generated method stub
		return descent;
	}

	public void enableDescend() {
		// TODO Auto-generated method stub
		this.descent=true;
	}
	public void disanableDescend() {
		this.descent=false;
	}

	public int getCyclesToDescend() {
		// TODO Auto-generated method stub
		return CyclesToDescend;
	}

	public void setCyclesToDescend(int i) {
		// TODO Auto-generated method stub
		this.CyclesToDescend=i;
	}

	public void decreasRemaniningAliens() {
		// TODO Auto-generated method stub
		this.remainingAliens--;
	}

	public boolean finalRowReached() {
		// TODO Auto-generated method stub
		return endRow;
	}
	
	public void isFinalRow() {
		this.endRow=true;
	}


}
