package com.scott.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scott.flightreservation.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
