package com.example.trainservice.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.trainservice.model.Seat;
import com.example.trainservice.service.SeatService;

@RestController
@CrossOrigin("*")
@RequestMapping("/seat")
public class SeatController {

	@Autowired
	SeatService seatService;
	
	@RequestMapping("/create")
	public Seat createSeat(@RequestParam String timeTableId,@RequestParam  String trainId,@RequestParam String seatNo,@RequestParam String seatClass,@RequestParam String bookingId,
			@RequestParam String userEmail,@RequestParam boolean isBooked) {
		
		return seatService.createSeat(timeTableId, trainId, seatNo, seatClass, bookingId, userEmail, isBooked);
		
	}
	
	@RequestMapping("/getAllSeats")
	public List<String> getAllSeats(@RequestParam String timetableId, @RequestParam String seatClass){
		return seatService.getAllSeatList(timetableId, seatClass);
	}
	
	@RequestMapping("/getReservedSeats")
	public List<String> getReservedSeats(@RequestParam String timetableId, @RequestParam String seatClass){
		return seatService.getReservedSeatList(timetableId, seatClass);
	}
	
	@RequestMapping("/getAvailableSeats")
	public List<String> getAvailableSeats(@RequestParam String timetableId, @RequestParam String seatClass){
		return seatService.getAvailableSeatList(timetableId, seatClass);
	}
	
	@RequestMapping("/bookSeats")
	public void bookSeats(@RequestParam String timeTableId,@RequestParam String seatList,@RequestParam String email,@RequestParam String cost) throws Exception {
		seatService.bookSeats(timeTableId, seatList,email,cost);
	}
	@RequestMapping("/getCost")
	public float getCost(@RequestParam String email, @RequestParam String timaTableId,@RequestParam int noOfSeats,@RequestParam String SeatClass ) {
		return seatService.getCost(email, timaTableId, noOfSeats, SeatClass);
	}
	
	
	//@RequestMapping("/getBookedSeats")
	
}
