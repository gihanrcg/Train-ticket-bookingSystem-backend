package com.example.trainservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.trainservice.model.Train;

@Repository
public interface TrainRepository extends MongoRepository<Train, String>{

	public Train findByTrainId(String trainId);
	public List<Train> findByIsAvailable(boolean isAvailable);
	
}
