package me.shockyng.rentacarjakartaee.exceptions;

public class NoDataAtTheDataBaseException extends RuntimeException {

    public NoDataAtTheDataBaseException(Class<?> aClass) {
        super(String.format("No %s found at the data base", aClass.getName()));
    }

    public NoDataAtTheDataBaseException(Class<?> aClass, Number id) {
        super(String.format("No %s found at the data base with id: %s", aClass.getSimpleName(), id));
    }
}
