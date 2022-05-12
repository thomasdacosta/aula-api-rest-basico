package edu.senac.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.UUID;

public class ErroRequest implements Serializable {

    private static final long serialVersionUID = 557098096679648463L;

    private Integer code;
    private String message;
    private String detail;
    private String traceId = UUID.randomUUID().toString();

    public static ErroRequest badRequest(Exception ex) {
        return ErroRequest.create().code(HttpStatus.BAD_REQUEST.value()).message("BAD_REQUEST")
                .detail(ex.getMessage());
    }

    public static ErroRequest notFound(Exception ex) {
        return ErroRequest.create().code(HttpStatus.NOT_FOUND.value()).message("NOT_FOUND").detail(ex.getMessage());
    }

    public static ErroRequest methodNotSupported(Exception ex) {
        return ErroRequest.create().code(HttpStatus.METHOD_NOT_ALLOWED.value()).message("METHOD_NOT_ALLOWED")
                .detail(ex.getMessage());
    }

    public static ErroRequest internalServerError(Exception ex) {
        return ErroRequest.create().code(HttpStatus.INTERNAL_SERVER_ERROR.value()).message("INTERNAL_SERVER_ERROR")
                .detail(ex.getMessage());
    }

    public static ErroRequest methodNotImplementedException(Exception ex) {
        return ErroRequest.create().code(HttpStatus.NOT_IMPLEMENTED.value()).message("METHOD_NOT_IMPLEMENTED")
                .detail(ex.getMessage());
    }

    public static ErroRequest create() {
        return new ErroRequest();
    }

    public ErroRequest code(Integer code) {
        this.setCode(code);
        return this;
    }

    public ErroRequest message(String message) {
        this.setMessage(message);
        return this;
    }

    public ErroRequest detail(String detail) {
        this.setDetail(detail);
        return this;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getDetail() {
        return detail;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

}
