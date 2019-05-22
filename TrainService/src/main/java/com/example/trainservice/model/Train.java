package com.example.trainservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Train {

	@Id
	String trainId;	
	String trainName;
	int firstClassSeatCount;
	int secondClassSeatCount;
	int thirdClassSeatCount;
	boolean isAvailable;
	
	public Train(String trainName, int firstClassSeatCount, int secondClassSeatCount, int thirdClassSeatCount,
			boolean isAvailable) {
		super();
		this.trainName = trainName;
		this.firstClassSeatCount = firstClassSeatCount;
		this.secondClassSeatCount = secondClassSeatCount;
		this.thirdClassSeatCount = thirdClassSeatCount;
		this.isAvailable = isAvailable;
	}

	public String getTrainId() {
		return trainId;
	}

	public void setTrainId(String trainId) {
		this.trainId = trainId;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public int getFirstClassSeatCount() {
		return firstClassSeatCount;
	}

	public void setFirstClassSeatCount(int firstClassSeatCount) {
		this.firstClassSeatCount = firstClassSeatCount;
	}

	public int getSecondClassSeatCount() {
		return secondClassSeatCount;
	}

	public void setSecondClassSeatCount(int secondClassSeatCount) {
		this.secondClassSeatCount = secondClassSeatCount;
	}

	public int getThirdClassSeatCount() {
		return thirdClassSeatCount;
	}

	public void setThirdClassSeatCount(int thirdClassSeatCount) {
		this.thirdClassSeatCount = thirdClassSeatCount;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	@Override
	public String toString() {
		return "Train [trainId=" + trainId + ", trainName=" + trainName + ", firstClassSeatCount=" + firstClassSeatCount
				+ ", secondClassSeatCount=" + secondClassSeatCount + ", thirdClassSeatCount=" + thirdClassSeatCount
				+ ", isAvailable=" + isAvailable + "]";
	}
	
	
	
	
}
