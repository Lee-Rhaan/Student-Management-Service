package com.xgileit.learning.student.controller;

import com.xgileit.learning.student.model.Student;
import com.xgileit.learning.student.service.TeacherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/api/v1/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService)
    {
        this.teacherService = teacherService;
    }

    /**
     * How to access this method: "/api/v1/student/all"
     * @return list of all students stored in database.
     */
    @GetMapping("/all")
    public List<Student> listAllStudents()
    {
        return teacherService.getAllStudents();
    }

    @GetMapping("/attending")
    public List<Student> studentsAttendingClass()
    {
        return teacherService.attendingClass();
    }

    @GetMapping("/not/attending")
    public List<Student> studentsNotAttendingClass()
    {
        return teacherService.notAttendingClass();
    }

}
