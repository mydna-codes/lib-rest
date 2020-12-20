package codes.mydna.validation;

import codes.mydna.exceptions.NullInputException;
import codes.mydna.exceptions.ValidationException;

public class Assert {

    /**
     * Throws Rest exception if object is not null
     * @param objectClass - Object class
     * @param o - Object to be checked
     * */
    public static void fieldNotNull(Object o, Class<?> objectClass){
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
     * @param objectClass - Field's parent object
     * @param field - Field to be checked
     * @param fieldName - Name of field
     * */
    public static void fieldNotNull(Object field, String fieldName, Class<?> objectClass){
        if(field == null)
            throw new NullInputException(objectClass, fieldName);
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
     * @param entityClass - Field's parent object
     * @param field - Field to be checked
     * @param fieldName - Name of field
     * */
    public static void fieldNotEmpty(String field, String fieldName, Class<?> entityClass){
        fieldNotNull(field, fieldName);
        if(field.isEmpty())
            throw new ValidationException(entityClass, fieldName);
    }

}
