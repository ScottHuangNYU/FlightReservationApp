package com.scott.flightreservation.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.scott.flightreservation.dto.ReservationRequest;
import com.scott.flightreservation.entities.Flight;
import com.scott.flightreservation.entities.Reservation;
import com.scott.flightreservation.repos.FlightRepository;
import com.scott.flightreservation.services.ReservationService;

@Controller
public class ReservationController {
	
	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	ReservationService reservationService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationController.class);
	
	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") Long flightId,ModelMap modelMap) {
		
		LOGGER.info("Inside showCompleteReservation() invoked with Flight Id :" + flightId );
		Flight flight = flightRepository.findOne(flightId);
		LOGGER.info("Flight is:" + flight);
		modelMap.addAttribute("flight", flight);
		return "completeReservation";
	}
	
	@RequestMapping(value="/completeReservation", method=RequestMethod.POST)
	public String completeReservation(ReservationRequest request, ModelMap modelMap) {
		LOGGER.info("Inside completeReservation()" + request);
		Reservation reservation = reservationService.bookFlight(request);
		
		modelMap.addAttribute("msg","Reservation created successfully and the id is "+reservation.getId());
		return "reservationConfirmation";
	}
}
