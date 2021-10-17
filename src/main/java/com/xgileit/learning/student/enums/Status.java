package com.xgileit.learning.student.enums;

public enum Status {
    IN_CLASS("IN_CLASS"), NOT_IN_CLASS("NOT_IN_CLASS");

    private final String status;

    Status(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }
}
