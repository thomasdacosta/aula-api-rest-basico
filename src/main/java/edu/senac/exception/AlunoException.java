package edu.senac.exception;

public class AlunoException extends RuntimeException {

    public AlunoException() {
    }

    public AlunoException(String message) {
        super(message);
    }

    public AlunoException(String message, Throwable cause) {
        super(message, cause);
    }

    public AlunoException(Throwable cause) {
        super(cause);
    }

    public AlunoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
