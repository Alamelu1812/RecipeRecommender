package recipe.exception;

public class MarshalUnmarshalException extends RuntimeException {

	public MarshalUnmarshalException(String message, Throwable cause) {
		super(cause);
	}
}
