package tp1.control.commands;

import exception.CommandExecuteException;
import tp1.logic.GameModel;
import tp1.view.Messages;

public class ExitCommand extends NoParamsCommand{
		  		
		@Override
		public boolean execute(GameModel game) throws CommandExecuteException {
			game.exit();
			return true;
		}

		@Override
		protected String getName() {
			return Messages.COMMAND_EXIT_NAME;
		}

		@Override
		protected String getShortcut() {
			return Messages.COMMAND_EXIT_SHORTCUT;
		}

		@Override
		protected String getDetails() {
			return Messages.COMMAND_EXIT_DETAILS;
		}

		@Override
		protected String getHelp() {
			return Messages.COMMAND_EXIT_HELP;
		}


	}
