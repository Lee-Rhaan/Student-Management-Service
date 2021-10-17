package com.xgileit.learning.student.exception;

public class AdminNotFoundException extends RuntimeException{

    public AdminNotFoundException(String message)
    {
        super(message);
    }
}
