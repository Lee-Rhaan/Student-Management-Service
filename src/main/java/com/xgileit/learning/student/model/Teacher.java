package com.xgileit.learning.student.model;

import com.xgileit.learning.student.enums.Authority;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Teacher implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String surname;
    private String address;
    private String email;
    private String phone;
    private String employeeCode;
    private Authority authority;
    @Transient
    private String fullName;

    public Teacher(){}

    public Teacher(String name, String surname, String address, String email, String phone,
                 String employeeCode, Authority authority)
    {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.employeeCode = employeeCode;
        this.authority = authority;
    }

    /**
     *
     * @return teacher object's id
     */
    public Long getId()
    {
        return id;
    }

    /**
     *
     * @return teacher object's name
     */
    public String getName()
    {
        return name;
    }

    /**
     * This method initializes the teacher object's name with the value provided in parameters.
     * @param name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     *
     * @return teacher object's surname
     */
    public String getSurname()
    {
        return surname;
    }

    /**
     * This method initializes the teacher object's surname with the value provided in parameters.
     * @param surname
     */
    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    /**
     *
     * @return teacher object's address
     */
    public String getAddress()
    {
        return address;
    }

    /**
     * This method initializes the teacher object's address with the value provided in parameters.
     * @param address
     */
    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getEmployeeCode()
    {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode)
    {
        this.employeeCode = employeeCode;
    }

    public Authority getAuthority()
    {
        return authority;
    }

    public void setAuthority(Authority authority)
    {
        this.authority = authority;
    }

    /**
     * Concatenates name & surname
     *
     * @return teacher name & surname
     */
    public String getFullName()
    {
        //Concatenated it here because when I do it in the constructor, the request is still
        //successful, but it returns an empty string.
        this.fullName = name + " " + surname;
        return fullName;
    }

    /**
     * If two objects are equal, their hashcodes should also be equal. Otherwise you'd never be able
     * to find the object since the default hashcode method in class "Object" virtually always comes
     * up with a unique number for each object (even if the "equals()" method is overridden in such
     * a way that two or more objects are considered equal).
     *
     * That is why i'm overriding these two methods.
     *
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(id, name, surname, address, fullName, email, phone, employeeCode, authority);
    }

    @Override
    public boolean equals(Object object)
    {
        if(this == object)
            return true;
        if(object == null)
            return false;
        if(getClass() != object.getClass())
            return false;

        Teacher teacher = (Teacher) object;
        return Objects.equals(id, teacher.id) &&
                Objects.equals(name, teacher.name) &&
                Objects.equals(surname, teacher.surname) &&
                Objects.equals(address, teacher.address) &&
                Objects.equals(fullName, teacher.fullName) &&
                Objects.equals(email, teacher.email) &&
                Objects.equals(phone, teacher.phone) &&
                Objects.equals(employeeCode, teacher.employeeCode) &&
                Objects.equals(authority, teacher.authority);
    }

    /**
     * It's just to make the contents of the Teacher object more readable.
     * @return
     */
    @Override
    public String toString()
    {
        return "Teacher {" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address='" + address + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", employeeCode='" + employeeCode + '\'' +
                ", authority='" + authority + '\'' +
                '}';
    }
}
