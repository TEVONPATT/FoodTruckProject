package com.skilldistillery.foodproject;

public class FoodTruck {
	private String truckName;
	private String foodType;
	private double rating;
	private static int truckID;
	private int uniqueID;

	public FoodTruck() {
	}

	public FoodTruck(String truckName, String foodType, double rating) {
		this.truckName = truckName;
		this.foodType = foodType;
		this.rating = rating;
		this.uniqueID = truckID++;
	}

	public String getTruckName() {
		return truckName;
	}

	public void setTruckName(String truckName) {
		this.truckName = truckName;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public int getTruckID() {
		return truckID;
	}

	public void setTruckID(int truckID) {
		this.truckID = truckID;
	}

	public String toString() {
		String output = "truck name: " + truckName + ", food type: " + foodType + ", rating: " + rating + " truck ID: "
				+ uniqueID;
		return output;
	}

	public void displayTruck() {
		String truckData = toString();
		System.out.println(truckData);
	}

}
