package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // GET: Retrieve all students
    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    // POST: Add new student
    @PostMapping
    public Student registerNewStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    // DELETE: Delete student by ID
    @DeleteMapping(path = "{studentId}")
    public ResponseEntity<Void> deleteStudent(@PathVariable("studentId") Long id) {
        boolean deleted = studentService.deleteStudent(id);
        if (deleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}