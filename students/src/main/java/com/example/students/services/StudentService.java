package com.example.students.services;


import com.example.students.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    public String addNewStudent(Student student);
    public String initStudent();
    public List<Student> findAllStudents();
    public Optional<Student> findStudentById(Long id);
}