package tp1.control.commands;

import java.io.FileNotFoundException;
import java.io.IOException;

import exception.CommandExecuteException;
import exception.CommandParseException;
import exception.InitializationException;
import exception.OffWorldException;
import tp1.control.InitialConfiguration;
import tp1.logic.Game;
import tp1.logic.GameModel;
import tp1.view.Messages;

public class ResetCommand extends Command{
	
	private InitialConfiguration conf;
	private Game game;
	protected ResetCommand(Game game, InitialConfiguration conf) {
		this.game=game;
		this.conf=conf;
	}
	
	protected ResetCommand() {
		
	}
	@Override
	protected String getName() {
		
		return Messages.COMMAND_RESET_NAME;
	}

	@Override
	protected String getShortcut() {
		
		return Messages.COMMAND_RESET_SHORTCUT;
	}

	@Override
	protected String getDetails() {
		
		return Messages.COMMAND_RESET_DETAILS;
	}

	@Override
	protected String getHelp() {
		
		return Messages.COMMAND_RESET_HELP;
	}

	@Override
	public boolean execute(GameModel game) throws CommandExecuteException {
		//if(conf != null)
			try {
				game.reset(conf);
			} catch (InitializationException | OffWorldException e) {
				throw new CommandExecuteException(Messages.INITIAL_CONFIGURATION_ERROR ,e);
			}
		//else game.reset();
		
		return true;
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		try {
			if(commandWords.length == 2 && this.matchCommandName(commandWords[0])) {
				try {
					this.conf = InitialConfiguration.readFromFile(commandWords[1]);
				} catch (FileNotFoundException e) {
					throw new CommandParseException(String.format(Messages.FILE_NOT_FOUND, commandWords[1]));
				} catch (IOException e) {
					throw new CommandParseException(Messages.UNEXPECTED_RUNTIME_ERROR);
				}
				return new ResetCommand(game, conf);
			}	
			if(commandWords.length == 1 && this.matchCommandName(commandWords[0])) {
				return new ResetCommand();
			}
		} catch(IllegalArgumentException e) {
			throw new CommandParseException(Messages.UNKNOWN_COMMAND);
		}
	    return null;
	}
}
	


