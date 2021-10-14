package com.xgileit.learning.student.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * This is the Entity class which will be mapped to the database.
 * The name of this Entity will be the Table Name in the database.
 * It's instance variables will be the column names in the database
 */
@Entity
public class Student implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String surname;
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
     * @param name
     * @param surname
     * @param address
     */
    public Student(String name, String surname, String address)
    {
        this.name = name;
        this.surname = surname;
        this.address = address;
    }

    /**
     *
     * @return student object's id
     */
    public Long getId()
    {
        return id;
    }

    /**
     *
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
     *
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
        return Objects.hash(id, name, surname, address, fullName);
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
                Objects.equals(fullName, student.fullName);
    }

    /**
     * Example Output: Student {id= '2', name= 'Lee', surname= 'Bee', address= 'SA'}
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
                '}';
    }
}
