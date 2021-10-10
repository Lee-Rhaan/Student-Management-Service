package com.xgileit.learning.student.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Serializable converts an object into byte streams. You usually have to implement this interface if
 * your object is going to leave the "JVM" at some point.
 */

@Table(name = "students")
@Entity
public class Student implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "student_number")
    private Long studentNumber;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String address;

    @Transient
    private String fullName;

    /**
     * The "JVM" always gives you a default constructor in your class unless you provide an
     * argument constructor (then the "JVM" won't provide the no-argument constructor).
     *
     * An empty constructor is needed to create a new instance via reflection by your persistence
     * framework.
     */
    public Student(){}

    /**
     * I did not initialize the studentNumber in this constructor, because i'm going to generate
     * a random studentNumber for each Student Object being created.
     * @param firstName
     * @param lastName
     * @param address
     */
    public Student(String firstName, String lastName, String address)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    /**
     *
     * @return student object's studentNumber
     */
    public Long getStudentNumber()
    {
        return studentNumber;
    }

    /**
     *
     * @return student object's firstName
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * This method initializes the student object's firstName with the value provided in parameters.
     * @param firstName
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    /**
     *
     * @return student object's lastName
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * This method initializes the student object's lastName with the value provided in parameters.
     * @param lastName
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    /**
     *
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
     * Concatenates firstName & lastName
     *
     * @return student's firstName & lastName
     */
    public String getFullName()
    {
        //Concatenated it here because when I do it in the constructor, the request is still
        //successful, but it returns an empty string.
        this.fullName = firstName + " " + lastName;
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
        return Objects.hash(studentNumber, firstName, lastName, address, fullName);
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
        return Objects.equals(studentNumber, student.studentNumber) &&
                Objects.equals(firstName, student.firstName) &&
                Objects.equals(lastName, student.lastName) &&
                Objects.equals(address, student.address) &&
                Objects.equals(fullName, student.fullName);
    }

    /**
     * Example Output: Student {studentNumber= '2', firstName= 'Lee', lastName= 'Bee', address= 'SA'}
     * It's just to make the contents of the Student object more readable.
     * @return
     */
    @Override
    public String toString()
    {
        return "Student {" +
                "studentNumber='" + studentNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
