package com.example.students.controller;

import com.example.students.entity.Lecture;
import com.example.students.entity.Student;
import com.example.students.services.LectureServiceImpl;
import com.example.students.services.StudentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("MySpringBootWeb")
public class StudentRestController {

	private static final Logger LOGGER = LoggerFactory.getLogger(StudentRestController.class);

	@Autowired
	StudentServiceImpl studentService;

	@Autowired
	LectureServiceImpl lectureService;


	@RequestMapping("/hello")
	public String sayHello() {

		return "Hello";

	}
	@RequestMapping("/initiate")
	public String initiateStudents() {
		studentService.initStudent();
		lectureService.initLecture();
		return "Students&Lectures created";

	}




	@GetMapping("students")
	public List<Student> getStudents() {
		List<Student> getStudents = null;
		getStudents=studentService.findAllStudents();
		return getStudents;

	}

	@GetMapping("lectures")
	public List<Lecture> getLectures() {
		List<Lecture> getlectures = null;
		getlectures=lectureService.findAllLectures();
		return getlectures;

	}


	@GetMapping("/students/{id}")
	public Student findStudent(@PathVariable("id") Long id) {
		return studentService.findStudentById(id).orElse(null);

	}

	@GetMapping("/lectures/{id}")
	public Lecture findLecture(@PathVariable("id") Long id) {

		return lectureService.findLectureById(id).orElse(null);

	}

	@RequestMapping("/greet")
	private String greet(String greet) {
		return "hi  "+greet;
	}


}
