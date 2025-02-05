package tp1.control.commands;

import exception.CommandExecuteException;
import tp1.logic.GameModel;
import tp1.view.Messages;

public class ListCommand extends NoParamsCommand{

	@Override
	protected String getName() {
		// TODO Auto-generated method stub
		return Messages.COMMAND_LIST_NAME;
	}

	@Override
	protected String getShortcut() {
		// TODO Auto-generated method stub
		return Messages.COMMAND_LIST_SHORTCUT;
	}

	@Override
	protected String getDetails() {
		// TODO Auto-generated method stub
		return Messages.COMMAND_LIST_DETAILS;
	}

	@Override
	protected String getHelp() {
		// TODO Auto-generated method stub
		return Messages.COMMAND_LIST_HELP;
	}

	@Override
	public boolean execute(GameModel game) throws CommandExecuteException{
		// TODO Auto-generated method stub
		System.out.println(game.infoToString());
		System.out.print("\n");
		return false;
	}

}
