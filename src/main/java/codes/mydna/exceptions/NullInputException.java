package codes.mydna.exceptions;

public class NullInputException extends BadRequestException {


    public NullInputException(String fieldName){
        super(String.format("'%s' cannot be null!", fieldName));
    }


    public NullInputException(Class<?> entityClass){
        super(String.format("Object '%s' cannot be null!", entityClass.getSimpleName()));
    }

    public NullInputException(Class<?> entityClass, String fieldName){
        super(String.format("Input field '%s' of an object '%s' cannot be null!", fieldName, entityClass.getSimpleName()));
    }

}
