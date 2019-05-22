package com.example.trainservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class TimeTable {

	@Id
	String timeTableId;
	
	String from;
	String to;
	String trainId;
	String arrivalTime;
	String departureTime;
	double cost;
	String date;
	boolean isLastStation;
	String stationType;
	
	public TimeTable(String from, String to, String trainId, String arrivalTime, String departureTime, double cost,
			String date, boolean isLastStation, String stationType) {
		super();
		this.from = from;
		this.to = to;
		this.trainId = trainId;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.cost = cost;
		this.date = date;
		this.isLastStation = isLastStation;
		this.stationType = stationType;
	}

	public String getTimeTableId() {
		return timeTableId;
	}

	public void setTimeTableId(String timeTableId) {
		this.timeTableId = timeTableId;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getTrainId() {
		return trainId;
	}

	public void setTrainId(String trainId) {
		this.trainId = trainId;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public boolean isLastStation() {
		return isLastStation;
	}

	public void setLastStation(boolean isLastStation) {
		this.isLastStation = isLastStation;
	}

	public String getStationType() {
		return stationType;
	}

	public void setStationType(String stationType) {
		this.stationType = stationType;
	}	
}
