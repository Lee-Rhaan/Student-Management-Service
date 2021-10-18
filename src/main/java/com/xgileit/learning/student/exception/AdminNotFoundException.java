package com.xgileit.learning.student.exception;

public class AdminNotFoundException extends RuntimeException{

    /**
     * This constructor will take the message provided when a new instance of this exception is created,
     * and display it to the user.
     * @param message
     */
    public AdminNotFoundException(String message)
    {
        super(message);
    }
}
