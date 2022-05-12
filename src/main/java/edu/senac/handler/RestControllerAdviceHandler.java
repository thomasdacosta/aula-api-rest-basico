package edu.senac.handler;

import edu.senac.dto.ErroRequest;
import edu.senac.exception.AlunoException;
import edu.senac.exception.MethodNotImplementedException;
import edu.senac.exception.OperationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestControllerAdviceHandler extends ResponseEntityExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(RestControllerAdviceHandler.class);

	/**
	 * Erro 400
	 */
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		logger.error(ex.getMessage(), ex);
		return new ResponseEntity<>(ErroRequest.badRequest(ex), status);
	}

	/**
	 * Erro 400
	 */
	@Override
	protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status,
			WebRequest request) {
		logger.error(ex.getMessage(), ex);
		return new ResponseEntity<>(ErroRequest.badRequest(ex), status);
	}

	/**
	 * Erro 400
	 */
	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		logger.error(ex.getMessage(), ex);
		return new ResponseEntity<>(ErroRequest.badRequest(ex), status);
	}

	/**
	 * Erro 404
	 */
	@Override
	protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		logger.error(ex.getMessage(), ex);
		return new ResponseEntity<>(ErroRequest.notFound(ex), status);
	}

	/**
	 * Erro 405
	 */
	@Override
	public ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		logger.error(ex.getMessage(), ex);
		return new ResponseEntity<>(ErroRequest.methodNotSupported(ex), status);
	}

	/**
	 * Erro 404
	 */
	@ExceptionHandler(AlunoException.class)
	public ResponseEntity<Object> handleNotFound(AlunoException ex) {
		logger.error(ex.getMessage(), ex);
		return new ResponseEntity<>(ErroRequest.notFound(ex), HttpStatus.NOT_FOUND);
	}

	/**
	 * Erro 500 - OperationException
	 */
	@ExceptionHandler(OperationException.class)
	public ResponseEntity<Object> handleOperationException(final Exception ex) {
		logger.error(ex.getMessage(), ex);
		return new ResponseEntity<>(ErroRequest.internalServerError(ex), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * Erro 500 - Exception
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleException(final Exception ex) {
		logger.error(ex.getMessage(), ex);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ErroRequest.create()
				.code(HttpStatus.INTERNAL_SERVER_ERROR.value()).message("GENERIC_EXCEPTION").detail(ex.getMessage()));
	}

	/**
	 * Erro 501 - OperationException
	 */
	@ExceptionHandler(MethodNotImplementedException.class)
	public ResponseEntity<Object> handleMethodNotImplementedException(final Exception ex) {
		logger.error(ex.getMessage(), ex);
		return new ResponseEntity<>(ErroRequest.methodNotImplementedException(ex), HttpStatus.NOT_IMPLEMENTED);
	}

}
