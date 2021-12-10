package com.example.students.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="reservation")
public class Reservation   extends AbstractEntity  {


    Long reservationId;

    @OneToOne
    private Student student;
    @OneToOne
    private Lecture lecture;


    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Lecture getLecture() {
        return lecture;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }
}