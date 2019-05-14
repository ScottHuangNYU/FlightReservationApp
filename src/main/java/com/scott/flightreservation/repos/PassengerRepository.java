package com.scott.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scott.flightreservation.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
