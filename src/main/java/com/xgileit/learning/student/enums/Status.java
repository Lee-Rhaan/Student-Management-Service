package com.xgileit.learning.student.enums;

/**
 * This enum class allows me to set the status of the students in this student management
 * service with predefined enum constants
 */
public enum Status {
    IN_CLASS("IN_CLASS"), NOT_IN_CLASS("NOT_IN_CLASS");

    private final String status;

    /**
     * Initializing status variable with argument provided in parameters
     *
     * @param status String
     */
    Status(String status)
    {
        this.status = status;
    }

    /**
     * @return status of specified object
     */
    public String getStatus()
    {
        return status;
    }
}
