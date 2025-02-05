package exception;

public class NoShockWaveException extends GameModelException{

	public NoShockWaveException() {
		super();
	}
	public NoShockWaveException(String messages) {
		super(messages);
	}
	public NoShockWaveException(String messages, Throwable cause) {
		super(messages, cause);
	}
	public NoShockWaveException(Throwable cause) {
		super(cause);
	}
}
