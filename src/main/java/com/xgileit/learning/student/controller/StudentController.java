package com.xgileit.learning.student.controller;

import com.xgileit.learning.student.service.StudentService;
import com.xgileit.learning.student.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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

    StudentService studentService = new StudentService();

    /**
     * How to access this method: "/api/v1/student/all"
     * @return list of all the student objects stored in database.
     */
    @GetMapping("/all")
    public Map<Long, Student> listAllStudents()
    {
        return studentService.getAllStudents();
    }

    /**
     * How to access this method: "/api/v1/student/add"
     * This method adds a new student object to the database.
     * @param student object
     * @return "String" response ("Student Added"), if the request were successful.
     */
    @PostMapping("/add")
    public String addStudent(@RequestBody Student student)
    {
        String response = studentService.addNewStudent(student);
        return response;
    }

    /**
     * How to access this method: "/api/v1/student/update"
     *
     * This method will replace the old student object with this newly updated student object
     * if the student object exists in the database.
     *
     * @param student object
     * @return "String" response ("Student Updated"), if the request were successful.
     */
    @PutMapping("/update")
    public String updateStudent(@RequestBody Student student)
    {
        String response = studentService.updateStudent(student);
        return response;
    }

    /**
     * How to access this method: "/api/v1/student/find/the studentNumber"
     *
     * The "{studentNumber}" is a place holder, indicating that it's not the actual value,
     * the actual value will be added during runtime.
     * The @PathVariable annotation indicates that the argument this method receives -> is bound to
     * the URI Template Variable, which in this case is "{studentNumber}".
     *
     * This method will find a student object by it's studentNumber in the database.
     *
     * @param studentNumber
     * @return student object
     */
    @GetMapping("/find/{studentNumber}")
    public Student findStudentByStudentNumber(@PathVariable("studentNumber") Long studentNumber)
    {
        return studentService.findStudentByStudentNumber(studentNumber);
    }

    /**
     * How to access this method: "/api/v1/student/delete/ the studentNumber"
     *
     * The "{studentNumber}" is a place holder, indicating that it's not the actual value,
     * the actual value will be added during runtime.
     * The @PathVariable annotation indicates that the argument this method receives -> is bound to
     * the URI Template Variable, which in this case is "{studentNumber}".
     *
     * This method will delete a student object from the database by using it's studentNumber as
     * a reference.
     *
     * @param studentNumber
     * @return "String" response ("Student Deleted") if the request were successful.
     */
    @DeleteMapping("/delete/{studentNumber}")
    public String deleteStudentByStudentNumber(@PathVariable("studentNumber") Long studentNumber)
    {
        String response = studentService.deleteStudentByStudentNumber(studentNumber);
        return response;
    }

}
