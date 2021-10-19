package com.xgileit.learning.student.controller;

import com.xgileit.learning.student.model.Student;
import com.xgileit.learning.student.service.StudentService;
import org.springframework.web.bind.annotation.*;

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
     * How to access this method: "/api/v1/student/attendClass"
     * Changing the status of the student.
     *
     * @param student object
     * @return updated student
     */
    @PutMapping("/attendClass")
    public Student attendClass(@RequestBody Student student)
    {
        return studentService.attendClass(student);
    }

    /**
     * How to access this method: "/api/v1/student/leaveClass"
     * Changing the status of the student.
     *
     * @param student object
     * @return updated student
     */
    @PutMapping("/leaveClass")
    public Student leaveClass(@RequestBody Student student)
    {
        return studentService.leaveClass(student);
    }

    /**
     * How to access this method: "/api/v1/student/unregister/id"
     * removing the student from this student management service.
     *
     * @param id
     */
    @DeleteMapping("/unregister/{id}")
    public void unregister(@PathVariable("id") Long id)
    {
        studentService.unregister(id);
    }
}
