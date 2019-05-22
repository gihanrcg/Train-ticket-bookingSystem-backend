package com.example.trainservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.trainservice.model.Station;

@Repository
public interface StationRepository extends MongoRepository<Station, String> {

	public Station findByStations(String station);
	public List<Station> findByType(String type);
	 
	
}
