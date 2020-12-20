package codes.mydna.exceptions;

public class ValidationException extends BadRequestException {

    public ValidationException(String fieldName){
        super(String.format("Input field '%s' cannot be empty!", fieldName));
    }

    public ValidationException(Class<?> entityClass, String fieldName){
        super(String.format("Input field '%s' of object '%s' cannot be empty!", fieldName, entityClass.getSimpleName()));
    }

}
