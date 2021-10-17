package com.xgileit.learning.student.repo;

import com.xgileit.learning.student.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    Optional<Admin> findAdminById(Long id);

    void deleteAdminById(Long id);
}
