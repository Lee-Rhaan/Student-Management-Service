package com.xgileit.learning.student.service;

import com.xgileit.learning.student.model.Student;
import com.xgileit.learning.student.repo.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    //should be able to do attendance
    //list all the students in the classroom
    //list all the students not in the classroom
    private final StudentRepository studentRepository;
    private final ClassroomService classroomService;

    public TeacherService(StudentRepository studentRepository, ClassroomService classroomService)
    {
        this.studentRepository = studentRepository;
        this.classroomService = classroomService;
    }

    public List<Student> getAllStudents()
    {
        return studentRepository.findAll();
    }

    public List<Student> attendingClass()
    {
        return classroomService.studentsAttendingClass();
    }

    public List<Student> notAttendingClass()
    {
        return classroomService.studentsNotAttendingClass();
    }
}
