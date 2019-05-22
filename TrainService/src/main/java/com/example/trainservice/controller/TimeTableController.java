package com.example.trainservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.trainservice.model.TimeTable;
import com.example.trainservice.service.TimeTableService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/timetable")
public class TimeTableController {

	@Autowired
	TimeTableService timeTableService;
	
	@RequestMapping("/insert")
	public TimeTable insertTimeTableRow(@RequestParam String from, @RequestParam String to, @RequestParam String trainId,
			@RequestParam String arrivalTime, @RequestParam String departureTime, @RequestParam double cost,
			@RequestParam String date, @RequestParam boolean isLastStation, @RequestParam String stationType) {

				
		return timeTableService.createTimeTableRow(from, to, trainId, arrivalTime, departureTime, cost, date, isLastStation, stationType);
	}

	
	@RequestMapping("/getAll")
	public List<TimeTable> getAllTimeTables(){
		return timeTableService.getAllTimeTableRows();
	}
	
	@RequestMapping("/getValidRows")
	public List<TimeTable> getValidRows(@RequestParam String from, @RequestParam String to,@RequestParam String date){
		return timeTableService.getTimeTableRows(from, to,date);
	}
	
	@RequestMapping("/byId")
	public Optional<TimeTable> getTimeTableById(@RequestParam String id) {
		return timeTableService.getTimeTableByid(id);
	}
}
