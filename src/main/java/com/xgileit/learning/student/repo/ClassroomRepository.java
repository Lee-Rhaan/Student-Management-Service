package com.xgileit.learning.student.repo;

import com.xgileit.learning.student.model.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassroomRepository extends JpaRepository<Classroom, Long> {
}
