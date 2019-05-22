package com.example.trainservice.repository;



import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.trainservice.model.Seat;

@Repository
public interface SeatRepository extends MongoRepository<Seat, String> {

	public List<Seat> findBySeatClass(String seatClass);
	public List<Seat> findBySeatNo(String seatNo);
	public List<Seat> findByIsBooked(boolean isBooked);
	public List<Seat> findBySeatClassAndTimeTableId(String seatClass, String timeTableId);

}
