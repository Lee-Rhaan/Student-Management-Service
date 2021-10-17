package com.xgileit.learning.student.exception;

public class TeacherNotFoundException extends RuntimeException{

    public TeacherNotFoundException(String message)
    {
        super(message);
    }
}
