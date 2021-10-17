package com.xgileit.learning.student.service;

import com.xgileit.learning.student.enums.Status;
import com.xgileit.learning.student.model.Student;
import com.xgileit.learning.student.repo.StudentRepository;

import java.util.ArrayList;
import java.util.List;

public class ClassroomService {

    private final StudentRepository studentRepository;

    public ClassroomService(StudentRepository studentRepository)
    {
        this.studentRepository = studentRepository;
    }

    public void attendClass(Student student)
    {
        student.setStatus(Status.IN_CLASS);
    }

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
