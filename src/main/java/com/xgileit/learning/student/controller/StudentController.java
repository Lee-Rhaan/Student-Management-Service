package com.xgileit.learning.student.controller;

import com.xgileit.learning.student.model.Student;
import com.xgileit.learning.student.service.StudentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/api/v1/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService)
    {
        this.studentService = studentService;
    }

    @PutMapping("/attendClass")
    public Student attendClass(@RequestBody Student student)
    {
        return studentService.attendClass(student);
    }

    @PutMapping("/leaveClass")
    public Student leaveClass(@RequestBody Student student)
    {
        return studentService.leaveClass(student);
    }

    @DeleteMapping("/unregister/{id}")
    public void unregister(@PathVariable("id") Long id)
    {
        studentService.unregister(id);
    }
}
