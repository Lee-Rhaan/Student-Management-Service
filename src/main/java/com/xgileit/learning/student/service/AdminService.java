package com.xgileit.learning.student.service;

import com.xgileit.learning.student.enums.Authority;
import com.xgileit.learning.student.enums.Status;
import com.xgileit.learning.student.exception.AdminNotFoundException;
import com.xgileit.learning.student.exception.StudentNotFoundException;
import com.xgileit.learning.student.exception.TeacherNotFoundException;
import com.xgileit.learning.student.model.Admin;
import com.xgileit.learning.student.model.Student;
import com.xgileit.learning.student.model.Teacher;
import com.xgileit.learning.student.repo.AdminRepository;
import com.xgileit.learning.student.repo.StudentRepository;
import com.xgileit.learning.student.repo.TeacherRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * This is the Service class. Here I am implementing all the business logic of this application.
 */
@Service
public class AdminService {

    private final AdminRepository adminRepository;
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;

    /**
     * Here I am injecting the adminRepository, studentRepository and teacherRepository in this
     * class in order to have access to all it's functionalities.
     * @param adminRepository, studentRepository, teacherRepository
     */
    public AdminService(AdminRepository adminRepository, StudentRepository studentRepository,
                        TeacherRepository teacherRepository)
    {
        this.adminRepository = adminRepository;
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
    }

    public List<Teacher> getAllTeachers()
    {
        return teacherRepository.findAll();
    }

    public List<Admin> getAllAdmins()
    {
        return adminRepository.findAll();
    }

    /**
     * Adds a new student into the database
     *
     * @param student object
     * @return saved student
     */
    public Student registerStudent(Student student)
    {
        student.setStudentCode(UUID.randomUUID().toString());
        student.setAuthority(Authority.STUDENT);
        student.setStatus(Status.NOT_IN_CLASS);

        return studentRepository.save(student);
    }

    public Teacher employTeacher(Teacher teacher)
    {
        teacher.setEmployeeCode(UUID.randomUUID().toString());
        teacher.setAuthority(Authority.TEACHER);

        return teacherRepository.save(teacher);
    }

    public Admin employAdmin(Admin admin)
    {
        admin.setEmployeeCode(UUID.randomUUID().toString());
        admin.setAuthority(Authority.ADMIN);

        return adminRepository.save(admin);
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

    public Teacher updateTeacher(Teacher teacher)
    {
        return teacherRepository.save(teacher);
    }

    public Admin updateAdmin(Admin admin)
    {
        return adminRepository.save(admin);
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

    public Teacher findTeacher(Long id)
    {
        return teacherRepository.findTeacherById(id).orElseThrow(() ->
                new TeacherNotFoundException("Teacher with id: " + id + " not found"));
    }

    public Admin findAdmin(Long id)
    {
        return adminRepository.findAdminById(id).orElseThrow(() ->
                new AdminNotFoundException("Admin with id: " + id + " not found"));
    }

    /**
     * Checks if a teacher with a matching id exists in the database.
     * If it exists, the teacher will be removed.
     *
     * @param id Long
     */
    @Transactional
    public void deleteTeacher(Long id)
    {
        teacherRepository.deleteTeacherById(id);
    }

    @Transactional
    public void deleteAdmin(Long id)
    {
        adminRepository.deleteAdminById(id);
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

    public String getTeacherFullName(Long id)
    {
        Optional<Teacher> teacher = teacherRepository.findTeacherById(id);
        return teacher.get().getFullName();
    }

    public String getAdminFullName(Long id)
    {
        Optional<Admin> admin = adminRepository.findAdminById(id);
        return admin.get().getFullName();
    }
}
