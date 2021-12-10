package com.example.students.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="lecture")
public class Lecture  implements Serializable {
@Id
    private Long lectureId;
    private String lecturename;

    public Long getLectureId() {
        return lectureId;
    }

    public void setLectureId(Long lectureId) {
        this.lectureId = lectureId;
    }

    public String getLecturename() {
        return lecturename;
    }

    public void setLecturename(String lecturename) {
        this.lecturename = lecturename;
    }

    public Lecture(Long lectureId, String lecturename) {
        this.lectureId = lectureId;
        this.lecturename = lecturename;
    }
    public Lecture() {

    }
}
