package com.example.trainservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.trainservice.model.TimeTable;

@Repository
public interface TimeTableRepository extends MongoRepository<TimeTable, String> {

	
}
