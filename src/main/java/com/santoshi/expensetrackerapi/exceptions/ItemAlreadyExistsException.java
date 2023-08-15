package com.santoshi.expensetrackerapi.exceptions;

public class ItemAlreadyExistsException extends RuntimeException {

    private static final long serialVersionUID = 1;

    public ItemAlreadyExistsException(String message) {
        super(message);
    }

}
