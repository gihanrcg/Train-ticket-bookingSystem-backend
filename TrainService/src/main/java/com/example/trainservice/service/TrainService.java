package com.example.trainservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.trainservice.model.Train;
import com.example.trainservice.repository.TrainRepository;

@Service
public class TrainService {

	@Autowired
	TrainRepository trainRepository;

	public Train createTrain(String trainName, int firstClassSeatCount, int secondClassSeatCount,
			int thirdClassSeatCount, boolean isAvailable) {

		return trainRepository.save(
				new Train(trainName, firstClassSeatCount, secondClassSeatCount, thirdClassSeatCount, isAvailable));
	}

	
	public Train updateTrain(String trainId, String trainName, int firstClassSeatCount, int secondClassSeatCount,
			int thirdClassSeatCount, boolean isAvailable) {
		
		Train temp = trainRepository.findByTrainId(trainId);
		temp.setTrainName(trainName);
		temp.setFirstClassSeatCount(firstClassSeatCount);
		temp.setSecondClassSeatCount(secondClassSeatCount);
		temp.setThirdClassSeatCount(thirdClassSeatCount);
		temp.setAvailable(isAvailable);
		return trainRepository.save(temp);
		

	}

}