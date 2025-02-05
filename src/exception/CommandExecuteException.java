package exception;

public class CommandExecuteException extends Exception {
	public CommandExecuteException() {
		super();
	}
	public CommandExecuteException(String messages) {
		super(messages);
	}
	public CommandExecuteException(String messages, Throwable cause) {
		super(messages, cause);
	}
	public CommandExecuteException(Throwable cause) {
		super(cause);
	}
}
