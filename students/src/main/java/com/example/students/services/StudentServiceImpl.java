package com.example.students.services;


import com.example.students.entity.Student;
import com.example.students.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public String initStudent() {

        String message="";
        Student student1=new Student(1L,"Ayse");
        Student student2=new Student(2L,"Fatma");
        studentRepository.save(student1);
        studentRepository.save(student2);
        message="success";
        return message;
    }


    @Override
    public String addNewStudent(Student student) {
        String message="";
        studentRepository.save(student);
        message="success";
        return message;
    }

    @Override
     public Optional<Student> findStudentById(Long id){

        return studentRepository.findById(id);
     }


    @Override
    public List<Student> findAllStudents() {

        return studentRepository.findAll();
    }
}
