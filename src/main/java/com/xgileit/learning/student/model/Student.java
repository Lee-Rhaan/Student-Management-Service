package com.xgileit.learning.student.model;

import com.xgileit.learning.student.enums.Authority;
import com.xgileit.learning.student.enums.Status;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * This is the Student Entity class which will be mapped to the database.
 * This entity will store all the students in this student management service.
 */
@Entity
public class Student implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String surname;
    private String address;
    private String email;
    private String phone;
    private String studentCode;
    private Authority authority;
    private Status status;
    @Transient
    private String fullName;

    /**
     * An empty constructor is needed to create a new instance via reflection by your persistence
     * framework.
     */
    public Student(){}

    /**
     * This is the student details every student needs to submit in order to be stored in the
     * database.
     * @param name
     * @param surname
     * @param address
     * @param email
     * @param phone
     */
    public Student(String name, String surname, String address, String email, String phone)
    {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

    /**
     * @return student object's id
     */
    public Long getId()
    {
        return id;
    }

    /**
     * @return student object's name
     */
    public String getName()
    {
        return name;
    }

    /**
     * This method initializes the student object's name with the value provided in parameters.
     * @param name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * @return student object's surname
     */
    public String getSurname()
    {
        return surname;
    }

    /**
     * This method initializes the student object's surname with the value provided in parameters.
     * @param surname
     */
    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    /**
     * @return student object's address
     */
    public String getAddress()
    {
        return address;
    }

    /**
     * This method initializes the student object's address with the value provided in parameters.
     * @param address
     */
    public void setAddress(String address)
    {
        this.address = address;
    }

    /**
     * @return student object's email
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * This method initializes the student object's email with the value provided in parameters.
     * @param email
     */
    public void setEmail(String email)
    {
        this.email = email;
    }

    /**
     * @return student object's phone
     */
    public String getPhone()
    {
        return phone;
    }

    /**
     * This method initializes the student object's phone with the value provided in parameters.
     * @param phone
     */
    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    /**
     * @return student object's studentCode
     */
    public String getStudentCode()
    {
        return studentCode;
    }

    /**
     * This method initializes the student object's studentCode with the value provided in parameters.
     * @param studentCode
     */
    public void setStudentCode(String studentCode)
    {
        this.studentCode = studentCode;
    }

    /**
     * @return student object's authority (values = STUDENT, TEACHER, ADMIN)
     */
    public Authority getAuthority()
    {
        return authority;
    }

    /**
     * This method initializes the student object's authority with the value provided in parameters.
     * @param authority
     */
    public void setAuthority(Authority authority)
    {
        this.authority = authority;
    }

    /**
     * @return student object's status (values = IN_CLASS, NOT_IN_CLASS)
     */
    public Status getStatus()
    {
        return status;
    }

    /**
     * This method initializes the student object's status with the value provided in parameters.
     * @param status
     */
    public void setStatus(Status status)
    {
        this.status = status;
    }

    /**
     * Concatenates name & surname
     *
     * @return student's name & surname
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
        return Objects.hash(id, name, surname, address, fullName, email, phone,
                studentCode, authority, status);
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

        Student student = (Student) object;
        return Objects.equals(id, student.id) &&
                Objects.equals(name, student.name) &&
                Objects.equals(surname, student.surname) &&
                Objects.equals(address, student.address) &&
                Objects.equals(fullName, student.fullName) &&
                Objects.equals(email, student.email) &&
                Objects.equals(phone, student.phone) &&
                Objects.equals(studentCode, student.studentCode) &&
                Objects.equals(authority, student.authority) &&
                Objects.equals(status, student.status);
    }

    /**
     * It's just to make the contents of the Student object more readable.
     * @return
     */
    @Override
    public String toString()
    {
        return "Student {" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address='" + address + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", studentCode='" + studentCode + '\'' +
                ", authority='" + authority + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
