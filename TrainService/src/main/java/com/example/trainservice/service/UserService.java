package com.example.trainservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.trainservice.model.User;
import com.example.trainservice.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User create(String firstName, String lastName, String email, String password,boolean isGovernment) {
		return userRepository.save(new User(firstName, lastName, email, password,isGovernment));
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public User updateUser(String firstName, String lastName, String email, String password) {

		User temp = userRepository.findByEmail(email);
		if (firstName != null && !firstName.equals("")) {
			temp.setFirstName(firstName);
		}
		if (lastName != null && !lastName.equals("")) {
			temp.setLastName(lastName);
		}

		if (password != null && !password.equals("")) {
			temp.setPassword(password);
		}
		return userRepository.save(temp);
	}

	public boolean deleteUser(String email) {
		User temp = userRepository.findByEmail(email);
		if (temp != null) {
			userRepository.delete(temp);
			return true;
		}else {
			return false;
		}
	}

}
