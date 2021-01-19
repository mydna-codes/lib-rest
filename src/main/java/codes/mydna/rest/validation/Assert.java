package codes.mydna.rest.validation;

import codes.mydna.rest.exceptions.BadRequestException;
import codes.mydna.rest.exceptions.NullInputException;
import codes.mydna.rest.exceptions.UnauthorizedException;
import codes.mydna.rest.exceptions.ValidationException;

public class Assert {

    /**
     * Throws Rest exception if object is not null
     * @param objectClass - Object class
     * @param o - Object to be checked
     * */
    public static void objectNotNull(Object o, Class<?> objectClass){
        if(o == null)
            throw new NullInputException(objectClass);
    }

    /**
     * Throws Rest exception if field is not null
     * @param field - Field to be checked
     * @param fieldName - Name of field
     * */
    public static void fieldNotNull(Object field, String fieldName){
        if(field == null)
            throw new NullInputException(fieldName);
    }

    /**
     * Throws Rest exception if field of an object is not null
     * @param parentClass - Field's parent object
     * @param field - Field to be checked
     * @param fieldName - Name of field
     * */
    public static void fieldNotNull(Object field, String fieldName, Class<?> parentClass){
        if(field == null)
            throw new NullInputException(parentClass, fieldName);
    }


    /**
     * Throws Rest exception if field is empty
     * @param field - Field to be checked
     * @param fieldName - Name of field
     * */
    public static void fieldNotEmpty(String field, String fieldName){
        fieldNotNull(field, fieldName);
        if(field.isEmpty())
            throw new ValidationException(fieldName);
    }

    /**
     * Throws Rest exception if field of an object is empty
     * @param parentClass - Field's parent object
     * @param field - Field to be checked
     * @param fieldName - Name of field
     * */
    public static void fieldNotEmpty(String field, String fieldName, Class<?> parentClass){
        fieldNotNull(field, fieldName, parentClass);
        if(field.isEmpty())
            throw new ValidationException(parentClass, fieldName);
    }

    /**
     * Throws rest exception if string value is not valid enum type
     * @param enumClass - enum class
     * @param value - String value of enum type
     */
    public static <E extends Enum<E>> void validEnum(Class<E> enumClass, String value){
        try {
            E.valueOf(enumClass, value);
        } catch (IllegalArgumentException e) {
            throw new BadRequestException("Invalid " + enumClass.getSimpleName() + " value.");
        }
    }

    /**
     * If user object is null, Unauthorized exception will be thrown
     * @param user - User object
     */
    public static void userNotNull(Object user){
        if(user == null) {
            throw new UnauthorizedException("Only logged in users can access requested action.");
        }
    }
}
