package com.xgileit.learning.student.service;

import com.xgileit.learning.student.exception.StudentNotFoundException;
import com.xgileit.learning.student.model.Student;
import com.xgileit.learning.student.repo.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * This is the Service class. Here I am implementing all the business logic of this application.
 */
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    /**
     * Here I am injecting the studentRepository in this class in order to have access to all it's
     * functionalities.
     * @param studentRepository
     */
    public StudentService(StudentRepository studentRepository)
    {
        this.studentRepository = studentRepository;
    }

    /**
     *
     * @return list of all the students in the database
     */
    public List<Student> getAllStudents()
    {
        return studentRepository.findAll();
    }

    /**
     * Adds a new student into the database
     *
     * @param student object
     * @return saved student
     */
    public Student addNewStudent(Student student)
    {
        return studentRepository.save(student);
    }

    /**
     * Updates the properties of an existing student in the database.
     *
     * @param student object
     * @return updated student
     */
    public Student updateStudent(Student student)
    {
        return studentRepository.save(student);
    }

    /**
     * Checks if the id being passed as an argument exists in the database.
     *
     * @param id Long
     * @return student with matching id or throws a student not found exception if there's
     *         no matching id's in the database.
     */
    public Student findStudent(Long id)
    {
        return studentRepository.findStudentById(id).orElseThrow(() ->
                new StudentNotFoundException("Student with id: " + id + " not found"));
    }

    /**
     * Checks if a student with a matching id exists in the database.
     * If it exists, the student will be removed.
     *
     * @param id Long
     */
    @Transactional
    public void deleteStudent(Long id)
    {
        studentRepository.deleteStudentById(id);
    }

    /**
     * Checks if the student with the matching id exists in the database, then
     * it will return the FullName of the student.
     *
     * @param id Long
     * @return concatenated name & surname of student (String)
     */
    public String getStudentFullName(Long id)
    {
        Optional<Student> student = studentRepository.findStudentById(id);
        return student.get().getFullName();
    }
}
