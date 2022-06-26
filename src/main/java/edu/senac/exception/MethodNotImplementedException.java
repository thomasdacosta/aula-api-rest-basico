package edu.senac.exception;

public class MethodNotImplementedException extends RuntimeException {

	private static final long serialVersionUID = -5843647475294941207L;

	public MethodNotImplementedException() {
    }

    public MethodNotImplementedException(String message) {
        super(message);
    }

    public MethodNotImplementedException(String message, Throwable cause) {
        super(message, cause);
    }

    public MethodNotImplementedException(Throwable cause) {
        super(cause);
    }

    public MethodNotImplementedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
