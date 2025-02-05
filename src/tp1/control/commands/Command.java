package tp1.control.commands;

import exception.CommandExecuteException;
import exception.CommandParseException;
import tp1.logic.GameModel;

public abstract class Command {

	  protected abstract String getName();
	  protected abstract String getShortcut();
	  protected abstract String getDetails();
	  protected abstract String getHelp();
	 
	  
	  /**
		 * Execute the command.
		 * 
		 * @param game Where to execute the command.
		 * 
		 * @return {@code ExecutionResult} representing if command was successful and if board must be printed
		 */
	  public abstract boolean execute(GameModel game) throws CommandExecuteException;	  
	 
	  public abstract Command parse(String[] parameter) throws CommandParseException;
	  
	  protected boolean matchCommandName(String name) {
		    return getShortcut().equalsIgnoreCase(name) || getName().equalsIgnoreCase(name) /*|| (this.Space_none() != null && this.Space_none().equals(name))*/;
	  }
	  
	  public String helpText(){
	    return getDetails() + " : " + getHelp() + "\n";
	  }
}

