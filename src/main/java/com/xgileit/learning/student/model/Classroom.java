package com.xgileit.learning.student.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Classroom implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private Teacher teacher;
    @OneToMany
    private List<Student> student;

    public Classroom(){}

    public Classroom(Teacher teacher, List<Student> student)
    {
        this.teacher = teacher;
        this.student = student;
    }

    public Long getId()
    {
        return id;
    }

    public Teacher getTeacher()
    {
        return teacher;
    }

    public void setTeacher(Teacher teacher)
    {
        this.teacher = teacher;
    }

    public List<Student> getStudent()
    {
        return student;
    }

    public void setStudent(List<Student> student)
    {
        this.student = student;
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
        return Objects.hash(id, teacher, student);
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

        Classroom classroom = (Classroom) object;
        return Objects.equals(id, classroom.id) &&
                Objects.equals(teacher, classroom.teacher) &&
                Objects.equals(student, classroom.student);
    }

    /**
     * It's just to make the contents of the Classroom object more readable.
     * @return
     */
    @Override
    public String toString()
    {
        return "Admin {" +
                "id='" + id + '\'' +
                ", teacher='" + teacher + '\'' +
                ", student='" + student + '\'' +
                '}';
    }
}
