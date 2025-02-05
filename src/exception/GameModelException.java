package exception;

public class GameModelException extends Exception{
	public GameModelException() {
		super();
	}
	public GameModelException(String messages) {
		super(messages);
	}
	public GameModelException(String messages, Throwable cause) {
		super(messages, cause);
	}
	public GameModelException(Throwable cause) {
		super(cause);
	}
}
