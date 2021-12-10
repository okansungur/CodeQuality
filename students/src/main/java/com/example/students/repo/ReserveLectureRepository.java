package com.example.students.repo;

import com.example.students.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ReserveLectureRepository extends JpaRepository<Reservation, Long> {



}