package recipe.exception;

public class DataAccessException extends RuntimeException {

	public DataAccessException(String message, Throwable cause) {
		super(cause);
	}
}
