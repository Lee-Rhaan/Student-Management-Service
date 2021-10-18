package com.xgileit.learning.student.service;

import com.xgileit.learning.student.model.Student;
import com.xgileit.learning.student.repo.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This is the Service class. Here I am implementing all the business logic of this application.
 */
@Service
public class TeacherService {

    private final StudentRepository studentRepository;
    private final ClassroomService classroomService;

    /**
     * Here I am injecting the studentRepository and classroomService in this
     * class in order to have access to all it's functionalities.
     * @param studentRepository, classroomService
     */
    public TeacherService(StudentRepository studentRepository, ClassroomService classroomService)
    {
        this.studentRepository = studentRepository;
        this.classroomService = classroomService;
    }

    /**
     * @return list of students in database
     */
    public List<Student> getAllStudents()
    {
        return studentRepository.findAll();
    }

    /**
     * @return list of students attending class
     */
    public List<Student> attendingClass()
    {
        return classroomService.studentsAttendingClass();
    }

    /**
     * @return list of students not attending class
     */
    public List<Student> notAttendingClass()
    {
        return classroomService.studentsNotAttendingClass();
    }
}
