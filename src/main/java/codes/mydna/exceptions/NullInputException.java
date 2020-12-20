package codes.mydna.exceptions;

public class NullInputException extends BadRequestException {

    public NullInputException(Class<?> entityClass){
        super(String.format("Object '%s' cannot be null!", entityClass.getSimpleName()));
    }

    public NullInputException(String fieldName){
        super(String.format("Input field '%s' cannot be null!", fieldName));
    }

}
