package codes.mydna.exceptions;

import javax.ws.rs.core.Response;

public class BadRequestException extends RestException {

    public BadRequestException(String message){
        super(message, Response.Status.BAD_REQUEST);
    }

}
