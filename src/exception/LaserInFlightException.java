package exception;

public class LaserInFlightException extends GameModelException {
	public LaserInFlightException() {
		super();
	}
	public LaserInFlightException(String messages) {
		super(messages);
	}
	public LaserInFlightException(String messages, Throwable cause) {
		super(messages, cause);
	}
	public LaserInFlightException(Throwable cause) {
		super(cause);
	}
}
