package com.example.trainservice.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.trainservice.mail.EmailService;
import com.example.trainservice.mail.MailRequest;
import com.example.trainservice.model.Seat;
import com.example.trainservice.model.TimeTable;
import com.example.trainservice.model.User;
import com.example.trainservice.repository.SeatRepository;
import com.example.trainservice.repository.TimeTableRepository;
import com.example.trainservice.repository.UserRepository;

@Service
public class SeatService {

	@Autowired
	SeatRepository seatRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	TimeTableRepository timeTableRepository;

	@Autowired
	TimeTableService timetableService;

	@Autowired
	UserService userService;
	
	@Autowired 
	EmailService emailService;

	public Seat createSeat(String timeTableId, String trainId, String seatNo, String seatClass, String bookingId,
			String userEmail, boolean isBooked) {
		return seatRepository.save(new Seat(timeTableId, trainId, seatNo, seatClass, bookingId, userEmail, isBooked));

	}

	public List<String> getAllSeatList(String timeTableId, String seatClass) {

		List<String> allSeats = new ArrayList<String>();
		for (Seat s : seatRepository.findAll()) {

			if (s.getTimeTableId().equals(timeTableId) && s.getSeatClass().equals(seatClass)) {
				allSeats.add(s.getSeatNo());
			}
		}
		return allSeats;
	}

	public List<String> getReservedSeatList(String timeTableId, String seatClass) {

		List<String> allSeats = new ArrayList<String>();
		for (Seat s : seatRepository.findAll()) {

			if (s.getTimeTableId().equals(timeTableId) && s.getSeatClass().equals(seatClass) && s.isBooked()) {
				allSeats.add(s.getSeatNo());
			}
		}
		return allSeats;
	}

	public List<String> getAvailableSeatList(String timeTableId, String seatClass) {

		List<String> allSeats = new ArrayList<String>();
		for (Seat s : seatRepository.findAll()) {

			if (s.getTimeTableId().equals(timeTableId) && s.getSeatClass().equals(seatClass) && !s.isBooked()) {
				allSeats.add(s.getSeatNo());
			}
		}
		return allSeats;
	}

	public void bookSeats(String timeTableId, String seats, String email,String cost) throws Exception {
		for (String s : seats.split(",")) {
			bookSeat(timeTableId, s, email,seats);
		}
		sendmail(timetableService.findById(timeTableId), userService.findUserByEmail(email), seats,cost);
	}

	public float getCost(String email, String timaTableId, int noOfSeats, String SeatClass) {

		User u = userRepository.findByEmail(email);
		TimeTable t = null;
		for (TimeTable tt : timeTableRepository.findAll()) {
			if (tt.getTimeTableId().equals(timaTableId)) {
				t = tt;
			}
		}
		if (t != null) {
			double initalCost = t.getCost();
			if (SeatClass.equals("1")) {
				initalCost = initalCost * 2 * noOfSeats;

				if (u.isGovernment()) {
					return (float) (initalCost * 0.9);
				} else {
					return (float) (initalCost);
				}
			}
		}
		return 0;
	}

	public boolean bookSeat(String timeTableId, String seatNo, String email,String seatList) throws Exception {
		List<Seat> seats = seatRepository.findBySeatNo(seatNo);

		for (Seat s : seats) {
			if (s.getTimeTableId().equals(timeTableId)) {
				if (s.isBooked()) {
					throw new Exception("Seat no " + seatNo + "is already booked for this ride..");
				}
			}
		}

		for (Seat s : seats) {
			if (s.getTimeTableId().equals(timeTableId)) {
				if (!s.isBooked()) {
					s.setBooked(true);
					s.setUserEmail(email);
					seatRepository.save(s);

					

					return true;
				} else {
					throw new Exception("Seat no " + seatNo + "is already booked for this ride..");
				}
			}
		}
		return false;
	}

	public void sendmail(TimeTable timeTable, User user, String seatList,String cost)
			throws AddressException, MessagingException, IOException {

		Map<String, Object> model = new HashMap<>();
		model.put("date",timeTable.getDate());
		model.put("from",timeTable.getFrom());
		model.put("to",timeTable.getTo());
		model.put("arrival",timeTable.getArrivalTime()+" Hour");
		model.put("departure",timeTable.getDepartureTime() + " Hour");
		model.put("noOfSeats",seatList.split(",").length);
		model.put("seatList",seatList);
		model.put("name", user.getFirstName());
		
		String discount;
		if(user.isGovernment()) {
			discount = "You have recieved 10% discount";
		}else {
			discount = "0.00";
		}		
		model.put("discount",discount);
		model.put("cost",cost);
		
		MailRequest m = new MailRequest();
		m.setFrom("gihanrcg@gmail.com");
		m.setName(user.getFirstName());
		m.setSubject("Booking confirmation");
		m.setTo(user.getEmail());
		
		emailService.sendEmail(m, model);
		
		
	}

}
