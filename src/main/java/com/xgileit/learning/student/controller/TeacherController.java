package com.xgileit.learning.student.controller;

import com.xgileit.learning.student.model.Student;
import com.xgileit.learning.student.service.TeacherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * This is the Controller class. It specifies the endpoints you'd have to use to get access
 * to this server.
 *
 * The @RequestMapping annotation determines what type of requests this class handles. So in this case
 * if you want access to this class -> you need to access it through the base request("/api/v1/teacher")
 */
@RestController
@RequestMapping(value="/api/v1/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    /**
     * Here I am injecting the teacherService in this class in order to have access to all it's
     * functionalities.
     * @param teacherService
     */
    public TeacherController(TeacherService teacherService)
    {
        this.teacherService = teacherService;
    }

    /**
     * How to access this method: "/api/v1/teacher/all"
     * @return list of all students stored in database.
     */
    @GetMapping("/all")
    public List<Student> listAllStudents()
    {
        return teacherService.getAllStudents();
    }

    /**
     * How to access this method: "/api/v1/teacher/attending"
     * @return list of students attending class
     */
    @GetMapping("/attending")
    public List<Student> studentsAttendingClass()
    {
        return teacherService.attendingClass();
    }

    /**
     * How to access this method: "/api/v1/teacher/not/attending"
     * @return list of students not attending class
     */
    @GetMapping("/not/attending")
    public List<Student> studentsNotAttendingClass()
    {
        return teacherService.notAttendingClass();
    }

}
