package org.doctorapp.exceptions;

@SuppressWarnings("serial")
public class IdNotFoundException extends RuntimeException{

    public IdNotFoundException() {
    }

    public IdNotFoundException(String message) {
        super(message);
    }
}
