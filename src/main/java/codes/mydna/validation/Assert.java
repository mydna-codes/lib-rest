package codes.mydna.validation;

import codes.mydna.exceptions.NullInputException;

public class Assert {

    /**
     * Throws Rest exception if object is not null
     * @param objectClass - Object class
     * @param o - Object to be checked
     * */
    public static void objectNotNull(Class<?> objectClass,  Object o){
        if(o == null)
            throw new NullInputException(objectClass);
    }

    /**
     * Throws Rest exception if field is not null
     * @param objectClass - Object class
     * @param field - Object to be checked
     * @param fieldName - Name of field
     * */
    public static void fieldNotNull(Class<?> objectClass, Object field, String fieldName){
        if(field == null)
            throw new NullInputException(objectClass, fieldName);
    }

    /**
     * Checks whether field is not null
     * @param field - Object to be checked
     * @param fieldName - Name of field
     * */
    public static void fieldNotNull(Object field, String fieldName){
        if(field == null)
            throw new NullInputException(fieldName);
    }

}
