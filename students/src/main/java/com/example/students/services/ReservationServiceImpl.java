package com.example.students.services;


import com.example.students.dto.LectureRequest;
import com.example.students.entity.Lecture;
import com.example.students.entity.Reservation;
import com.example.students.entity.Student;
import com.example.students.repo.LectureRepository;
import com.example.students.repo.ReserveLectureRepository;
import com.example.students.repo.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

@Service
public class ReservationServiceImpl implements ReservationService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    LectureRepository lectureRepository;

    @Autowired
    ReserveLectureRepository reserveRepository;


    @Override
    @Transactional
    public Reservation reserveLecture(LectureRequest request) {

        Long requestId = request.getRequestId();
        Long studentId = request.getStudentId();
        Long lectureId = request.getLectureId();
        String semester = request.getSemester();
        LOGGER.info("Fetching request for request id:" + requestId);

        Student student = studentRepository.findById(studentId).orElse(null);
        Lecture lecture = lectureRepository.findById(lectureId).orElse(null);
        Reservation reservation = new Reservation();
        reservation.setLecture(lecture);
        reservation.setStudent(student);
        long generatedLong = new Random().nextLong();
        reservation.setId(generatedLong);

        Reservation reservation1 = reserveRepository.save(reservation);

        return reservation1;
    }





}
