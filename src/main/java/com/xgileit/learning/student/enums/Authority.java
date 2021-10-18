package com.xgileit.learning.student.enums;

/**
 * This enum class allows me to set the authority of the objects in this student management
 * service with predefined enum constants
 */
public enum Authority {
    ADMIN("ADMIN"), TEACHER("TEACHER"), STUDENT("STUDENT");

    private final String authority;

    /**
     * Initializing authority variable with argument provided in parameters
     *
     * @param authority String
     */
    Authority(String authority)
    {
        this.authority = authority;
    }

    /**
     * @return authority of specified object
     */
    public String getAuthority()
    {
        return authority;
    }
}
