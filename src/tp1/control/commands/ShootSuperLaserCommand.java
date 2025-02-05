package tp1.control.commands;

import exception.CommandExecuteException;
import exception.LaserInFlightException;
import exception.NotEnoughPointsException;
import tp1.logic.GameModel;
import tp1.view.Messages;

public class ShootSuperLaserCommand extends  NoParamsCommand{

	@Override
	protected String getName() {
		
		return Messages.COMMAND_SUPERLASER_NAME;
	}

	@Override
	protected String getShortcut() {
		
		return Messages.COMMAND_SUPERLASER_SHORTCUT;
	}

	@Override
	protected String getDetails() {
		
		return Messages.COMMAND_SUPERLASER_DETAILS;
	}

	@Override
	protected String getHelp() {
		
		return Messages.COMMAND_SUPERLASER_HELP;
	}

	@Override
	public boolean execute(GameModel game) throws CommandExecuteException {
		
		try {
			if(game.shootSuperLaser()) {
				game.update();
				return true;
			}
		} catch (LaserInFlightException | NotEnoughPointsException e) {
			throw new CommandExecuteException(Messages.SUPERLASER_ERROR, e);
		}
		return false;
	}

}
