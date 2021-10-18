package com.xgileit.learning.student.service;

import com.xgileit.learning.student.model.Student;
import com.xgileit.learning.student.repo.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * This is the Service class. Here I am implementing all the business logic of this application.
 */
@Service
public class StudentService {

    private final ClassroomService classroomService;
    private final StudentRepository studentRepository;

    /**
     * Here I am injecting the classroomService and studentRepository in this
     * class in order to have access to all it's functionalities.
     * @param classroomService, studentRepository
     */
    public StudentService(ClassroomService classroomService, StudentRepository studentRepository)
    {
        this.classroomService = classroomService;
        this.studentRepository = studentRepository;
    }

    /**
     * Changing the status of the student to "IN_CLASS", then saving the updated student.
     *
     * @param student object
     * @return updated student
     */
    public Student attendClass(Student student)
    {
        classroomService.attendClass(student);
        studentRepository.save(student);

        return student;
    }

    /**
     * Changing the status of the student to "NOT_IN_CLASS", then saving the updated student.
     *
     * @param student object
     * @return updated student
     */
    public Student leaveClass(Student student)
    {
        classroomService.leaveClass(student);
        studentRepository.save(student);

        return student;
    }

    /**
     * Delete the student with the matching id from the database
     *
     * @param id Long
     */
    @Transactional
    public void unregister(Long id)
    {
        studentRepository.deleteStudentById(id);
    }
}
