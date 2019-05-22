 package com.example.trainservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Seat {

	@Id
	String seatId;	
	String timeTableId;
	String trainId;
	String seatNo;
	String seatClass;
	String bookingId;
	String userEmail;
	boolean isBooked;
	
	public Seat(String timeTableId, String trainId, String seatNo, String seatClass, String bookingId,
			String userEmail,boolean isBooked) {
		super();
		this.timeTableId = timeTableId;
		this.trainId = trainId;
		this.seatNo = seatNo;
		this.seatClass = seatClass;
		this.bookingId = bookingId;
		this.userEmail = userEmail;
		this.isBooked = isBooked;
	}
	
	

	public boolean isBooked() {
		return isBooked;
	}



	public void setBooked(boolean isBooked) {
		this.isBooked = isBooked;
	}



	public String getSeatId() {
		return seatId;
	}

	public void setSeatId(String seatId) {
		this.seatId = seatId;
	}

	public String getTimeTableId() {
		return timeTableId;
	}

	public void setTimeTableId(String timeTableId) {
		this.timeTableId = timeTableId;
	}

	public String getTrainId() {
		return trainId;
	}

	public void setTrainId(String trainId) {
		this.trainId = trainId;
	}

	public String getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}

	public String getSeatClass() {
		return seatClass;
	}

	public void setSeatClass(String seatClass) {
		this.seatClass = seatClass;
	}

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	
	
	
	
	
	
}
