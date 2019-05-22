package com.example.trainservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.trainservice.model.Station;
import com.example.trainservice.repository.StationRepository;

@Service
public class StationService {

	@Autowired
	StationRepository stationRepo;

	public List<String> getAllStations(String type) {

		List<String> s = new ArrayList<String>();
		List<Station> stations = stationRepo.findByType(type);
		if (stations.size() == 1) {
			for (Station st : stations) {
				String[] list = st.getStations().split(",");
				for (String l : list) {
					s.add(l.trim().substring(1, l.trim().length() - 1));
				}
			}
		}
		return s;
	}

	public List<Station> getAll() {
		return stationRepo.findAll();
	}

	public String getType(String from, String to) {
		List<Station> allStations = getAll();
		for (Station s : allStations) {
			List<String> x = new ArrayList<String>();
			for (String text : s.getStations().split(",")) {
				x.add(text.trim().substring(1, text.trim().length() - 1));
			}
			if(x.contains(from) && x.contains(to)) {
				return s.getType();
			}
		}
		return "";

	}

}