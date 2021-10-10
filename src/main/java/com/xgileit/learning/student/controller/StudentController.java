package com.xgileit.learning.student.controller;

import com.xgileit.learning.student.model.Student;
import com.xgileit.learning.student.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The @RestController annotation is used to create Restful web services. It takes care of mapping
 * request data to the defined request handler method.
 *It's a special type of annotation (It consists of a @ResponseBody & @Controller annotation)
 * It eliminates the need to annotate every request handling method in this controller class with
 * a @ResponseBody annotation.
 *
 * The @ResponseBody annotation enables automatic serialization of the return object into the
 * HttpResponse (Serialization is when you convert an object into a stream of bytes).
 *
 * The @Controller annotation included in this @RestController annotation specifies that this class
 * is a controller class.
 * The @Controller annotation also indicates that this class is a component. So Spring Component Scanning
 * will automatically detect this class as a component, and create an instance of this class as a Bean
 * in Springs Application Context.
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
     * @return the student with his/her studentNumber if the request were successful
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
     * How to access this method: "/api/v1/student/find/the studentNumber"
     *
     * This method will find a student object by it's studentNumber in the database.
     *
     * @param studentNumber
     * @return student object if student exists in database or Error message if student
     *         with specified studentNumber does not exist in database
     */
    @GetMapping("/find/{studentNumber}")
    public Student findStudentByStudentNumber(@PathVariable("studentNumber") Long studentNumber)
    {
        return studentService.findStudent(studentNumber);
    }


    /**
     * How to access this method: "/api/v1/student/delete/ the studentNumber"
     *
     * This method will delete a student object from the database by using it's studentNumber as
     * a reference.
     *
     * @param studentNumber
     * @return empty response if request were successful
     */
    @DeleteMapping("/delete/{studentNumber}")
    public void deleteStudentByStudentNumber(@PathVariable("studentNumber") Long studentNumber)
    {
        studentService.deleteStudent(studentNumber);
    }

    /**
     * How to access this method: "/api/v1/student/fullName/ the studentNumber"
     *
     * This method will concatenate the student's firstName and lastName
     *
     * @param studentNumber
     * @return Concatenated String of firstName & lastName of student
     */
    @GetMapping("/fullName/{studentNumber}")
    public String getFullNameByStudentNumber(@PathVariable("studentNumber") Long studentNumber)
    {
        return studentService.getStudentFullName(studentNumber);
    }

}
