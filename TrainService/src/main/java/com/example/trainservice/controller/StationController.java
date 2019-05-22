package com.example.trainservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.trainservice.model.Station;
import com.example.trainservice.service.StationService;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/stations")
public class StationController {

	@Autowired
	StationService stationServer;
	
	@RequestMapping("/getStations")
	public List<String> create(@RequestParam String type) {
		
		return stationServer.getAllStations(type);
	}
	
	@RequestMapping("/getAllStations")
	public List<Station> getAll(){
		return stationServer.getAll();
	}
	
	@RequestMapping("/getType")
	public String getType(@RequestParam String from, @RequestParam String to) {
		return stationServer.getType(from, to);
	}
}
