package com.xgileit.learning.student.service;

import com.xgileit.learning.student.enums.Status;
import com.xgileit.learning.student.model.Student;
import com.xgileit.learning.student.repo.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the Service class. Here I am implementing all the business logic of this application.
 */
@Service
public class ClassroomService {

    private final StudentRepository studentRepository;

    /**
     * Here I am injecting the studentRepository in this class in order to have access
     * to all it's functionalities.
     * @param studentRepository
     */
    public ClassroomService(StudentRepository studentRepository)
    {
        this.studentRepository = studentRepository;
    }

    /**
     * Setting the status of the student to "IN_CLASS", to indicate that the student
     * is in a class at the moment.
     *
     * @param student object
     */
    public void attendClass(Student student)
    {
        student.setStatus(Status.IN_CLASS);
    }

    /**
     * Setting the status of the student to "NOT_IN_CLASS", to indicate that the student
     * is not in a class at the moment.
     *
     * @param student object
     */
    public void leaveClass(Student student)
    {
        student.setStatus(Status.NOT_IN_CLASS);
    }

    /**
     * Using a for loop to iterate over all the students in the database. Then extracting
     * those whose status is "IN_CLASS", and placing them in an arraylist.
     *
     * @return list of students with "IN_CLASS" status
     */
    public List<Student> studentsAttendingClass()
    {
        List<Student> students = new ArrayList<>();

        for(Student student : studentRepository.findAll())
        {
            if(student.getStatus() == Status.IN_CLASS)
            {
                students.add(student);
            }
        }

        return students;
    }

    /**
     * Using a for loop to iterate over all the students in the database. Then extracting
     * those whose status is "NOT_IN_CLASS", and placing them in an arraylist.
     *
     * @return list of students with "NOT_IN_CLASS" status
     */
    public List<Student> studentsNotAttendingClass()
    {
        List<Student> students = new ArrayList<>();

        for(Student student : studentRepository.findAll())
        {
            if(student.getStatus() == Status.NOT_IN_CLASS)
            {
                students.add(student);
            }
        }

        return students;
    }
}
