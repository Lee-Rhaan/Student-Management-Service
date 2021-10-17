package com.xgileit.learning.student.repo;

import com.xgileit.learning.student.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    Optional<Teacher> findTeacherById(Long id);

    void deleteTeacherById(Long id);
}
