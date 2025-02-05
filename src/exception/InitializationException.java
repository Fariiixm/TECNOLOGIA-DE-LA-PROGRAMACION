package exception;

public class InitializationException extends GameModelException{
	public InitializationException() {
		super();
	}
	public InitializationException(String messages) {
		super(messages);
	}
	public InitializationException(String messages, Throwable cause) {
		super(messages, cause);
	}
	public InitializationException(Throwable cause) {
		super(cause);
	}
}
