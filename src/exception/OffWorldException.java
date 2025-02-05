package exception;

public class OffWorldException extends GameModelException{

	public OffWorldException() {
		super();
	}
	public OffWorldException(String messages) {
		super(messages);
	}
	public OffWorldException(String messages, Throwable cause) {
		super(messages, cause);
	}
	public OffWorldException(Throwable cause) {
		super(cause);
	}
}
