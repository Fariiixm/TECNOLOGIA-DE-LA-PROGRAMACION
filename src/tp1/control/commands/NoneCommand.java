package tp1.control.commands;

import exception.CommandExecuteException;
import exception.CommandParseException;
import tp1.logic.GameModel;
import tp1.view.Messages;

public class NoneCommand extends NoParamsCommand{

	@Override
	protected String getName() {
		
		return Messages.COMMAND_NONE_NAME;
	}

	@Override
	protected String getShortcut() {
		
		return Messages.COMMAND_NONE_SHORTCUT;
	}

	@Override
	protected String getDetails() {
		
		return Messages.COMMAND_NONE_DETAILS;
	}

	@Override
	protected String getHelp() {
		
		return Messages.COMMAND_NONE_HELP;
	}

	@Override
	public boolean execute(GameModel game) throws CommandExecuteException {
		game.update();
		return true;
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		if (commandWords[0].equals("") || commandWords[0].equals(getName()) || commandWords[0].equals(getShortcut())) {
			if(commandWords.length != 1) 
				throw new CommandParseException(Messages.COMMAND_INCORRECT_PARAMETER_NUMBER);
			return this;
		}
		return null;
	}
}
