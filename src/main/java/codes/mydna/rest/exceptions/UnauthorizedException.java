package codes.mydna.rest.exceptions;

import javax.ws.rs.core.Response;

public class UnauthorizedException extends RestException {

    public UnauthorizedException(){
        super("Unauthorized!", Response.Status.UNAUTHORIZED);
    }

    public UnauthorizedException(String message){
        super(message, Response.Status.UNAUTHORIZED);
    }

}
