package com.javaguides.sms.service;

import com.javaguides.sms.exception.ResourceNotFound;
import com.javaguides.sms.model.Student;
import com.javaguides.sms.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        super();
        this.studentRepository = studentRepository;
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getStudent(Student student) {
        return  studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Student","Id",id));
    }

    @Override
    public Student updateStudent(Student student ,Long id) {
        Student existingStudent = studentRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Student", "Id", id));

        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());

        return studentRepository.save(existingStudent);
    }

//    @Override
//    public Student patchStudent(Student student, Long id) {
//        Student existingStudent = studentRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Student","Id",id));
//
//        existingStudent.setFirstName(student.getFirstName());
//        existingStudent.setLastName(student.getLastName());
//        existingStudent.setEmail(student.getEmail());
//
//        studen
//    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
