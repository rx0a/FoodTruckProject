package com.skilldistillery.app;

public class FoodTruck {
	private static int truckCount;
	private int truckNumber;
	private String truckName;
	private String truckType;
	private double truckRating;

	public FoodTruck() {
	}

	public FoodTruck(String truckName, String truckType, double truckRating) {
		this.truckName = truckName;
		this.truckType = truckType;
		this.truckRating = truckRating;
		truckCount++;
		truckNumber = truckCount;
	}

	public String getTruckName() {
		return truckName;
	}

	public void setTruckName(String truckName) {
		this.truckName = truckName;
	}

	public String getTruckType() {
		return truckType;
	}

	public void setTruckType(String truckType) {
		this.truckType = truckType;
	}

	public double getTruckRating() {
		return truckRating;
	}

	public void setTruckRating(double truckRating) {
		this.truckRating = truckRating;
	}

	@Override
	public String toString() {
		String output = "ID: " + truckNumber + " Name: " + truckName + " Type: " + truckType + " Rating: "
				+ truckRating;

		return output;
	}

	public void displayTruck() {
		String truckData = this.toString();
		System.out.println(truckData);
	}

}
