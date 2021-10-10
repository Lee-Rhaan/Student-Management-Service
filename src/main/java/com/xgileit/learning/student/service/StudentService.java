package com.xgileit.learning.student.service;

import com.xgileit.learning.student.exception.StudentNotFoundException;
import com.xgileit.learning.student.model.Student;
import com.xgileit.learning.student.repo.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * You basically need to use the @Transactional Annotation when one part in your program
 * is going to have an effect on another part of your program.
 * So the reason i'm using it here is because when I delete a student from the database, it's
 * going to have an effect on the "getAllStudents".
 *
 * Meaning that if I don't add this annotation, I won't be able to delete a student from the
 * database.
 *
 * And i've added the @Service annotation to this class because Spring could not detect
 * a Bean for this class.
 */
@Transactional
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
     * Checks if the studentNumber being passed as an argument exists in the database.
     *
     * @param studentNumber Long
     * @return student with matching studentNumber or throws a student not found exception if there's
     *         no matching studentNumbers in the database.
     */
    public Student findStudent(Long studentNumber)
    {
        return studentRepository.findStudentByStudentNumber(studentNumber).orElseThrow(() ->
                new StudentNotFoundException("Student with studentNumber: " + studentNumber + " not found"));
    }

    /**
     * Checks if a student with a matching studentNumber exists in the database.
     * If it exists, the student will be removed.
     *
     * @param studentNumber Long
     */
    public void deleteStudent(Long studentNumber)
    {
        studentRepository.deleteStudentByStudentNumber(studentNumber);
    }

    /**
     * Checks if the student with the matching studentNumber exists in the database, then
     * it will return the FullName of the student.
     *
     * @param studentNumber Long
     * @return concatenated firstName & lastName of student (String)
     */
    public String getStudentFullName(Long studentNumber)
    {
        Optional<Student> student = studentRepository.findStudentByStudentNumber(studentNumber);
        return student.get().getFullName();
    }
}
