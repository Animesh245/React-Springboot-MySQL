package com.javaguides.sms.controller;

import com.javaguides.sms.model.Student;
import com.javaguides.sms.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        super();
        this.studentService = studentService;
    }



    //Post REST API
    @PostMapping("/api/post")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        return new ResponseEntity<Student>(studentService.saveStudent(student), HttpStatus.CREATED);
    }

    //GET REST API
    @GetMapping("/api/get")
    public List<Student> getStudent(Student student) {
        return studentService.getStudent(student);
    }


    //GET by Id REST API
    @GetMapping("/api/get/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") Long studentId) {
        return new ResponseEntity<Student>(studentService.getStudentById(studentId), HttpStatus.OK);
    }

    //PUT by ID REST API
    @PutMapping("/api/put/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") Long studentId,
                                                 @RequestBody Student student){
        return new ResponseEntity<Student>(studentService.updateStudent(student, studentId), HttpStatus.OK);
    }

    // PATCH by ID REST API
    @PatchMapping

    //DELETE by ID REST API
    @DeleteMapping("/api/delete/{id}")
    public ResponseEntity <String> deleteStudent(@PathVariable("id") Long studentId){
        studentService.deleteStudent(studentId);
        return new ResponseEntity<String >("Student is deleted successfully", HttpStatus.OK);
    }
}