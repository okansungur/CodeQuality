package com.example.students.services;


import com.example.students.entity.Lecture;
import com.example.students.entity.Student;
import com.example.students.exception.LectureNotFoundException;
import com.example.students.repo.LectureRepository;
import com.example.students.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LectureServiceImpl implements LectureService  {


    @Autowired
    LectureRepository lectureRepository;

    public String initLecture() {
        String message="";
        Lecture lecture1=new Lecture(100L,"Literature");
        Lecture lecture2=new Lecture(101L,"Algebra");


        lectureRepository.save(lecture1);
        lectureRepository.save(lecture2);
        message="success";
        return message;
    }

    @Override
    public Optional<Lecture> findLectureById(Long id){

        Optional<Lecture> lecture=lectureRepository.findById(id);
        if(lecture==null) throw new LectureNotFoundException();
        return lecture;
    }

    @Override
    public List<Lecture> findAllLectures() {

        return lectureRepository.findAll();
    }

}
