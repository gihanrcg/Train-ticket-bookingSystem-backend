package com.example.trainservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.trainservice.model.TimeTable;
import com.example.trainservice.repository.TimeTableRepository;

@Service
public class TimeTableService {

	@Autowired
	TimeTableRepository timeTableRepository;
	
	@Autowired
	StationService stationService;
	
	public TimeTable createTimeTableRow(String from, String to, String trainId, String arrivalTime, String departureTime, double cost,
			String date, boolean isLastStation, String stationType) {

		return timeTableRepository.save(new TimeTable(from, to, trainId, arrivalTime, departureTime, cost, date, isLastStation, stationType) );
		
	}
	
	public Optional<TimeTable> getTimeTableByid(String id) {
		return   timeTableRepository.findById(id);
	}
	
	public List<TimeTable> getAllTimeTableRows() {
		return timeTableRepository.findAll();
	}
	
	public TimeTable findById(String timeTableId) {
		
		for(TimeTable t : timeTableRepository.findAll()) {
			if(t.getTimeTableId().equals(timeTableId)) {
				return t;
			}
		}
		return null;
	}
	
	
	public List<TimeTable> getTimeTableRows(String from , String to, String date) {
		
		String type = stationService.getType(from, to);
		List<TimeTable> validRows = new ArrayList<TimeTable>(); 
		
		for(TimeTable tim : getAllTimeTableRows()) {
			if(tim.getFrom().equals(from) && tim.getTo().equals(to)) {
				if(date == null || date.equals("")) {
					validRows.add(tim);
				}else {
					if(date.equals(tim.getDate())) {
						validRows.add(tim);
					}
				}
			}
		}
		return validRows;
	}
	
}
