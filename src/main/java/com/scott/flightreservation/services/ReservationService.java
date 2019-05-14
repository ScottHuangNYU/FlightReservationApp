package com.scott.flightreservation.services;

import com.scott.flightreservation.dto.ReservationRequest;
import com.scott.flightreservation.entities.Reservation;

public interface ReservationService {
	
	public Reservation bookFlight(ReservationRequest request);
}
