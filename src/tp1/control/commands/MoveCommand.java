package tp1.control.commands;

import exception.CommandExecuteException;
import exception.CommandParseException;
import exception.NotAllowedMoveException;
import tp1.logic.GameModel;
import tp1.logic.Move;
import tp1.view.Messages;

public class MoveCommand extends Command {

	private Move move;

	public MoveCommand() {}

	public MoveCommand(Move move) {
		this.move = move;
	}

	@Override
	protected String getName() {
		return Messages.COMMAND_MOVE_NAME;
	}

	@Override
	protected String getShortcut() {
		return Messages.COMMAND_MOVE_SHORTCUT;
	}

	@Override
	protected String getDetails() {
		return Messages.COMMAND_MOVE_DETAILS;
	}

	@Override
	protected String getHelp() {
		return Messages.COMMAND_MOVE_HELP;
	}

	@Override
	public boolean execute(GameModel game) throws CommandExecuteException {

		 try {
		       if(game.move(this.move)) return true;
		       else {
		    	   throw new CommandExecuteException();
		       }
		    } catch (NotAllowedMoveException e) {
		    
		       throw new CommandExecuteException(Messages.MOVEMENT_ERROR, e);
		    }
		
	}


	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
	    if(commandWords.length == 2 && this.matchCommandName(commandWords[0])) {
	        try {
	            this.move = Move.stringToMove(commandWords[1]);
	        } catch (IllegalArgumentException  ex) {
	            throw new CommandParseException(Messages.DIRECTION_ERROR + commandWords[1].toUpperCase() + "\n" + Messages.ALLOWED_MOVES_MESSAGE);
	        }
	        return new MoveCommand(move);			
	    }	
	    return null;
	}
	
	

}
