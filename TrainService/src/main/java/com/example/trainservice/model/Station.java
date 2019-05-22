package com.example.trainservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Station {

	@Id
	String id;
	String type;
	String stations;
	
	public Station(String type, String stations) {
		super();
		this.type = type;
		this.stations = stations;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStations() {
		return stations;
	}

	public void setStations(String stations) {
		this.stations = stations;
	}

	@Override
	public String toString() {
		return "Station [id=" + id + ", type=" + type + ", stations=" + stations + "]";
	}
	
	
}
