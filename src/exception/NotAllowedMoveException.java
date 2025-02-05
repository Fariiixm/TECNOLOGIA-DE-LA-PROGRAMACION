package exception;

public class NotAllowedMoveException extends GameModelException{

	public NotAllowedMoveException() {
		super();
	}
	public NotAllowedMoveException(String messages) {
		super(messages);
	}
	public NotAllowedMoveException(String messages, Throwable cause) {
		super(messages, cause);
	}
	public NotAllowedMoveException(Throwable cause) {
		super(cause);
	}
}
