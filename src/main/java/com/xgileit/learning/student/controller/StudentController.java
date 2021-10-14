package com.xgileit.learning.student.controller;

import com.xgileit.learning.student.model.Student;
import com.xgileit.learning.student.service.StudentService;
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
@RequestMapping(value="/api/v1/student")
public class StudentController {

    private final StudentService studentService;

    /**
     * Here I am injecting the studentService in this class in order to have access to all it's
     * functionalities.
     * @param studentService
     */
    public StudentController(StudentService studentService)
    {
        this.studentService = studentService;
    }

    /**
     * How to access this method: "/api/v1/student/all"
     * @return list of all students stored in database.
     */
    @GetMapping("/all")
    public List<Student> listAllStudents()
    {
        return studentService.getAllStudents();
    }

    /**
     * How to access this method: "/api/v1/student/add"
     * This method adds a new student to the database.
     * @param student object
     * @return the student with his/her id if the request were successful
     */
    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student)
    {
        return studentService.addNewStudent(student);
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
    @PutMapping("/update")
    public Student updateStudent(@RequestBody Student student)
    {
        return studentService.updateStudent(student);
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
    @GetMapping("/find/{id}")
    public Student findStudentById(@PathVariable("id") Long id)
    {
        return studentService.findStudent(id);
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
    @DeleteMapping("/delete/{id}")
    public void deleteStudentById(@PathVariable("id") Long id)
    {
        studentService.deleteStudent(id);
    }

    /**
     * How to access this method: "/api/v1/student/fullName/id"
     *
     * This method will concatenate the student's name and surname
     *
     * @param id
     * @return Concatenated String of name & surname of student
     */
    @GetMapping("/fullName/{id}")
    public String getFullNameById(@PathVariable("id") Long id)
    {
        return studentService.getStudentFullName(id);
    }

}
