package com.example.students.services;

import com.example.students.dto.LectureRequest;
import com.example.students.entity.Reservation;


public interface ReservationService {
		public Reservation reserveLecture(LectureRequest request);
}
