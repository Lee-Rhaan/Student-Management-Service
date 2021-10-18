package com.xgileit.learning.student.service;

import com.xgileit.learning.student.model.Student;
import com.xgileit.learning.student.repo.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {

    //should be able to unregister
    //should be able to attend class
    private final ClassroomService classroomService;
    private final StudentRepository studentRepository;

    public StudentService(ClassroomService classroomService, StudentRepository studentRepository)
    {
        this.classroomService = classroomService;
        this.studentRepository = studentRepository;
    }

    public Student attendClass(Student student)
    {
        classroomService.attendClass(student);
        studentRepository.save(student);

        return student;
    }

    public Student leaveClass(Student student)
    {
        classroomService.leaveClass(student);
        studentRepository.save(student);

        return student;
    }

    @Transactional
    public void unregister(Long id)
    {
        studentRepository.deleteStudentById(id);
    }
}
