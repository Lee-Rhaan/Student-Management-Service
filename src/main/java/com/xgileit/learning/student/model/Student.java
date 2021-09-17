package com.xgileit.learning.student.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Serializable converts an object into byte streams. You usually have to implement this interface if
 * your object is going to leave the "JVM" at some point.
 */
public class Student implements Serializable {

    private Long studentNumber;
    private String firstName;
    private String secondName;
    private String address;

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
     * @param secondName
     * @param address
     */
    public Student(String firstName, String secondName, String address)
    {
        this.firstName = firstName;
        this.secondName = secondName;
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
     * The reason i've added this setter method, is because i'm using this method to initialize the
     * studentNumber when a new student is being created.
     * This method initializes the student object's studentNumber with the value provided in parameters.
     * @param studentNumber
     */
    public void setStudentNumber(Long studentNumber)
    {
        this.studentNumber = studentNumber;
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
     * @return student object's secondName
     */
    public String getSecondName()
    {
        return secondName;
    }

    /**
     * This method initializes the student object's secondName with the value provided in parameters.
     * @param secondName
     */
    public void setSecondName(String secondName)
    {
        this.secondName = secondName;
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
        return Objects.hash(studentNumber, firstName, secondName, address);
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
                Objects.equals(secondName, student.secondName) &&
                Objects.equals(address, student.address);
    }

    /**
     * Example Output: Student {studentNumber= '2', firstName= 'Lee', secondName= 'Bee', address= 'SA'}
     * It's just to make the contents of the Student object more readable.
     * @return
     */
    @Override
    public String toString()
    {
        return "Student {" +
                "studentNumber='" + studentNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
