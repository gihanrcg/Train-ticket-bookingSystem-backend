package com.example.trainservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.trainservice.model.User;
import com.example.trainservice.service.UserService;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/createUser")
	public String create(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email,
			@RequestParam String password) {
		User u = userService.create(firstName, lastName, email, password,false);
		return u.toString();
	}

	@RequestMapping("/isValidUser")
	public boolean isValidUser(@RequestParam String email, @RequestParam String password) {
		User u = userService.findUserByEmail(email);
		if (u != null) {
			if (u.getPassword().equals(password)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	@RequestMapping("/getUser")
	public User getUserByEmail(@RequestParam String email) {	
		return userService.findUserByEmail(email);		
	}
	
	@RequestMapping("/updateUser")
	public User updateUser(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email,
			@RequestParam String password) {	
		return userService.updateUser(firstName, lastName, email, password);		
	}
	
	
	@RequestMapping("/deleteUser")
	public boolean deleteUser(String email) {
		return userService.deleteUser(email);
	}

}
