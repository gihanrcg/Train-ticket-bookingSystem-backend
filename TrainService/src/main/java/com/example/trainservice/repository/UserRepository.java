package com.example.trainservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.trainservice.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

	public User findByFirstName(String firstName);
	public User findByEmail(String email);
	
}
