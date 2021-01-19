package codes.mydna.rest.exceptions;

import javax.ws.rs.core.Response;

public class InternalServerException extends RestException{

    public InternalServerException(){
        super("Internal server error!", Response.Status.INTERNAL_SERVER_ERROR);
    }

    public InternalServerException(String message){
        super(message, Response.Status.INTERNAL_SERVER_ERROR);
    }

}
