package org.doctorapp.exceptions;

@SuppressWarnings("serial")
public class DoctorNotFoundException extends RuntimeException{

    public DoctorNotFoundException() {
    }

    public DoctorNotFoundException(String message) {
        super(message);
    }
}
