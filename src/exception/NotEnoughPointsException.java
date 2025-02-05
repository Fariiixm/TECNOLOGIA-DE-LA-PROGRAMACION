package exception;

public class NotEnoughPointsException extends Exception {
	public NotEnoughPointsException() {
		super();
	}
	public NotEnoughPointsException(String messages) {
		super(messages);
	}
	public NotEnoughPointsException(String messages, Throwable cause) {
		super(messages, cause);
	}
	public NotEnoughPointsException(Throwable cause) {
		super(cause);
	}
}
