package codes.mydna.exceptions;

public class InvalidInputException extends BadRequestException {

    public InvalidInputException(Class<?> entityClass, String fieldName){
        super(String.format("Input field '%s' of object '%s' is invalid!", fieldName, entityClass.getSimpleName()));
    }

}
