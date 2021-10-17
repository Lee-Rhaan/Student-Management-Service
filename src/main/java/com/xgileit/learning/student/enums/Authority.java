package com.xgileit.learning.student.enums;

public enum Authority {
    ADMIN("ADMIN"), TEACHER("TEACHER"), STUDENT("STUDENT");

    private final String authority;

    Authority(String authority)
    {
        this.authority = authority;
    }

    public String getAuthority()
    {
        return this.authority;
    }
}
