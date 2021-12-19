package com.javaguides.sms.service;

import com.javaguides.sms.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    //    POST
    Student saveStudent(Student student);

    //    GET
    List<Student> getStudent(Student student);

    //    GET by ID
    Student getStudentById(Long id);

    //  PUT by ID
    Student updateStudent(Student student,Long id);

    // PATCH by ID
//    Student patchStudent(Student student, Long id);

    //  DELETE by ID
    void deleteStudent(Long id);

}
