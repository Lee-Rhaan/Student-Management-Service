package com.xgileit.learning.student.controller;

import com.xgileit.learning.student.model.Admin;
import com.xgileit.learning.student.model.Student;
import com.xgileit.learning.student.model.Teacher;
import com.xgileit.learning.student.service.AdminService;
import com.xgileit.learning.student.service.TeacherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This is the Controller class. It specifies the endpoints you'd have to use to get access
 * to this server.
 *
 * The @RequestMapping annotation determines what type of requests this class handles. So in this case
 * if you want access to this class -> you need to access it through the base request("/api/v1/student")
 */
@RestController
@RequestMapping(value="/api/v1/admin")
public class AdminController {

    private final AdminService adminService;

    /**
     * Here I am injecting the adminService in this class in order to have access to all it's
     * functionalities.
     * @param adminService
     */
    public AdminController(AdminService adminService)
    {
        this.adminService = adminService;
    }

    @GetMapping("/all/teacher")
    public List<Teacher> listAllTeachers()
    {
        return adminService.getAllTeachers();
    }

    @GetMapping("/all/admin")
    public List<Admin> listAllAdmins()
    {
        return adminService.getAllAdmins();
    }

    /**
     * How to access this method: "/api/v1/student/add"
     * This method adds a new student to the database.
     * @param student object
     * @return the student with his/her id if the request were successful
     */
    @PostMapping("/register/student")
    public Student registerStudent(@RequestBody Student student)
    {
        return adminService.registerStudent(student);
    }

    @PostMapping("/employ/teacher")
    public Teacher employTeacher(@RequestBody Teacher teacher)
    {
        return adminService.employTeacher(teacher);
    }

    @PostMapping("/employ/admin")
    public Admin employAdmin(@RequestBody Admin admin)
    {
        return adminService.employAdmin(admin);
    }

    /**
     * How to access this method: "/api/v1/student/update"
     *
     * This method will replace the old student object with this newly updated student object
     * if the student object exists in the database.
     *
     * @param student object
     * @return updated student if the request were successful
     */
    @PutMapping("/update/student")
    public Student updateStudent(@RequestBody Student student)
    {
        return adminService.updateStudent(student);
    }

    @PutMapping("/update/teacher")
    public Teacher updateTeacher(@RequestBody Teacher teacher)
    {
        return adminService.updateTeacher(teacher);
    }

    @PutMapping("/update/admin")
    public Admin updateAdmin(@RequestBody Admin admin)
    {
        return adminService.updateAdmin(admin);
    }

    /**
     * How to access this method: "/api/v1/student/find/id"
     *
     * This method will find a student object by it's id in the database.
     *
     * @param id
     * @return student object if student exists in database or Error message if student
     *         with specified id does not exist in database
     */
    @GetMapping("/find/student/{id}")
    public Student findStudent(@PathVariable("id") Long id)
    {
        return adminService.findStudent(id);
    }

    @GetMapping("/find/teacher/{id}")
    public Teacher findTeacher(@PathVariable("id") Long id)
    {
        return adminService.findTeacher(id);
    }

    @GetMapping("/find/admin/{id}")
    public Admin findAdmin(@PathVariable("id") Long id)
    {
        return adminService.findAdmin(id);
    }


    /**
     * How to access this method: "/api/v1/student/delete/id"
     *
     * This method will delete a student object from the database by using it's id as
     * a reference.
     *
     * @param id
     * @return empty response if request were successful
     */
    @DeleteMapping("/delete/teacher/{id}")
    public void deleteTeacher(@PathVariable("id") Long id)
    {
        adminService.deleteTeacher(id);
    }

    @DeleteMapping("/delete/admin/{id}")
    public void deleteAdmin(@PathVariable("id") Long id)
    {
        adminService.deleteAdmin(id);
    }

    /**
     * How to access this method: "/api/v1/student/fullName/id"
     *
     * This method will concatenate the student's name and surname
     *
     * @param id
     * @return Concatenated String of name & surname of student
     */
    @GetMapping("/student/fullName/{id}")
    public String getStudentFullName(@PathVariable("id") Long id)
    {
        return adminService.getStudentFullName(id);
    }

    @GetMapping("/teacher/fullName/{id}")
    public String getTeacherFullName(@PathVariable("id") Long id)
    {
        return adminService.getTeacherFullName(id);
    }

    @GetMapping("/admin/fullName/{id}")
    public String getAdminFullName(@PathVariable("id") Long id)
    {
        return adminService.getAdminFullName(id);
    }

}
