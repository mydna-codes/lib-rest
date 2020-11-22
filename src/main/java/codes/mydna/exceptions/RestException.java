package codes.mydna.exceptions;

import javax.ws.rs.core.Response;

public class RestException extends RuntimeException {

    private Integer statusCode;

    public RestException(String message) {
        super(message);
        this.statusCode = Response.Status.INTERNAL_SERVER_ERROR.getStatusCode();
    }
    public RestException(String message, Throwable cause) {
        super(message, cause);
        this.statusCode = Response.Status.INTERNAL_SERVER_ERROR.getStatusCode();
    }

    public RestException(String message, Response.Status status) {
        super(message);
        this.statusCode = status.getStatusCode();
    }

    public RestException(String message, int status) {
        super(message);
        this.statusCode = status;
    }

    public RestException(String message, Response.Status status, Throwable cause) {
        super(message, cause);
        this.statusCode = status.getStatusCode();
    }

    public RestException(String message, int statusCode, Throwable cause) {
        super(message, cause);
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

}
