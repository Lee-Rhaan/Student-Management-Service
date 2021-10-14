package com.xgileit.learning.student.repo;

import com.xgileit.learning.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * I'm extending this interface with "JpaRepository", to get access to all it's CRUD
 * functionalities.
 */
public interface StudentRepository extends JpaRepository<Student, Long> {

    /**
     * These are custom abstract methods I am going to be implementing in my service class.
     * The names of these methods are going to be read like queries by Spring.
     */
    void deleteStudentById(Long id);

    //setting it to optional, because this method may or may not return a value.
    Optional<Student> findStudentById(Long id);
}
