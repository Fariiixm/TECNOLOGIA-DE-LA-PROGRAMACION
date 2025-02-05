package tp1.control.commands;

import java.util.Arrays;
import java.util.List;

import exception.CommandParseException;
import tp1.view.Messages;

public class CommandGenerator {

	private static final List<Command> availableCommands = Arrays.asList(
		new HelpCommand(),
		new MoveCommand(),
		new NoneCommand(),
		new ShootCommand(),
		new ShockWaveCommand(),
		new ListCommand(),
		new ExitCommand(),
		new ResetCommand(),
		new ShootSuperLaserCommand()
		
	);

	public static Command parse(String[] commandWords) throws CommandParseException {		
		Command command = null;
		//try {
			for (Command c: availableCommands) {
				if(command == null) command = c.parse(commandWords); 
			}
			if(command == null) throw new CommandParseException(Messages.UNKNOWN_COMMAND);
		
		/*}catch(IllegalArgumentException e) {
			throw new CommandParseException(Messages.UNKNOWN_COMMAND);
		}*/
		return command;
	}
		
	public static String commandHelp() {
		StringBuilder commands = new StringBuilder();	
		for (Command c: availableCommands) {
			commands.append(c.helpText());
		}
		return commands.toString();
	}

}
