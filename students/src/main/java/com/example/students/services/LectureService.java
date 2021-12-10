package com.example.students.services;



import com.example.students.entity.Lecture;

import java.util.List;
import java.util.Optional;

public interface LectureService {

    public Optional<Lecture> findLectureById(Long id);
    public List<Lecture> findAllLectures();
}