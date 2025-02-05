package exception;

public class CommandParseException extends Exception{
	public CommandParseException() {
		super();
	}
	public CommandParseException(String messages) {
		super(messages);
	}
	public CommandParseException(String messages, Throwable cause) {
		super(messages, cause);
	}
	public CommandParseException(Throwable cause) {
		super(cause);
	}
}
