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

    /**
     * @return list of all teacher objects in database
     */
    public List<Teacher> getAllTeachers()
    {
        return teacherRepository.findAll();
    }

    /**
     * @return list of all admin objects in database
     */
    public List<Admin> getAllAdmins()
    {
        return adminRepository.findAll();
    }

    /**
     * Assigning the student object a unique studentCode upon registration.
     * Setting the student's authority to it's role in this student management service.
     * Setting it's status and then adding the student to the database.
     *
     * @param student object
     * @return registered student
     */
    public Student registerStudent(Student student)
    {
        student.setStudentCode(UUID.randomUUID().toString());
        student.setAuthority(Authority.STUDENT);
        student.setStatus(Status.NOT_IN_CLASS);

        return studentRepository.save(student);
    }

    /**
     * Assigning the teacher object a unique employeeCode upon employment.
     * Setting the teacher's authority to it's role in this student management service.
     * Then adding the teacher to the database.
     *
     * @param teacher object
     * @return employed teacher
     */
    public Teacher employTeacher(Teacher teacher)
    {
        teacher.setEmployeeCode(UUID.randomUUID().toString());
        teacher.setAuthority(Authority.TEACHER);

        return teacherRepository.save(teacher);
    }

    /**
     * Assigning the admin object a unique employeeCode upon employment.
     * Setting the admin's authority to it's role in this student management service.
     * Then adding the admin to the database.
     *
     * @param admin object
     * @return employed admin
     */
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

    /**
     * Updates the properties of an existing teacher in the database.
     *
     * @param teacher object
     * @return updated teacher
     */
    public Teacher updateTeacher(Teacher teacher)
    {
        return teacherRepository.save(teacher);
    }

    /**
     * Updates the properties of an existing admin in the database.
     *
     * @param admin object
     * @return updated admin
     */
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

    /**
     * Checks if the id being passed as an argument exists in the database.
     *
     * @param id Long
     * @return teacher with matching id or throws a teacher not found exception if there's
     *         no matching id's in the database.
     */
    public Teacher findTeacher(Long id)
    {
        return teacherRepository.findTeacherById(id).orElseThrow(() ->
                new TeacherNotFoundException("Teacher with id: " + id + " not found"));
    }

    /**
     * Checks if the id being passed as an argument exists in the database.
     *
     * @param id Long
     * @return admin with matching id or throws an admin not found exception if there's
     *         no matching id's in the database.
     */
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

    /**
     * Checks if an admin with a matching id exists in the database.
     * If it exists, the admin will be removed.
     *
     * @param id Long
     */
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

    /**
     * Checks if the teacher with the matching id exists in the database, then
     * it will return the FullName of the teacher.
     *
     * @param id Long
     * @return concatenated name & surname of teacher (String)
     */
    public String getTeacherFullName(Long id)
    {
        Optional<Teacher> teacher = teacherRepository.findTeacherById(id);
        return teacher.get().getFullName();
    }

    /**
     * Checks if the admin with the matching id exists in the database, then
     * it will return the FullName of the admin.
     *
     * @param id Long
     * @return concatenated name & surname of admin (String)
     */
    public String getAdminFullName(Long id)
    {
        Optional<Admin> admin = adminRepository.findAdminById(id);
        return admin.get().getFullName();
    }
}
