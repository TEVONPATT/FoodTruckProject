package com.skilldistillery.foodproject;

import java.util.Scanner;

public class FoodTruckApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		FoodTruckApp fTApp = new FoodTruckApp();
		fTApp.run(scanner);
	}

	private void run(Scanner scanner) {
		FoodTruck[] trucks = new FoodTruck[5];
//		System.out.println("==================================");
//		System.out.println("======_________________________====");
//		System.out.println("=====| Select a truck to view |====");
//		System.out.println("==___|                        |___===");
//		System.out.println("==| 1) Flippin Freddy's Pancakes |==");
//		System.out.println("==|______________________________|");
//		System.out.println("==================================");
//		System.out.println("==================================");
		boolean keepGoing = true;
//		while(keepGoing) {
//			
//		}
//		TODO break if less than 5 trucks

		for (int i = 0; i < trucks.length; i++) {
			FoodTruck truck = buildUserTruck(scanner);
			trucks[i] = truck;
		}
		trucks = getTestTruckArr();
		printTruck(trucks);
		averageRating(trucks);
		highestRating(trucks);
	}

	private void printTruck(FoodTruck[] trucks) {
		for (int i = 0; i < trucks.length; i++) {
			trucks[i].displayTruck();
		}

	}

	private void averageRating(FoodTruck[] trucks) {
		double countTrucks = 0;

		double sum = 0;
		for (int i = 0; i < trucks.length; i++) {
			if (trucks[i] != null) {
				sum += trucks[i].getRating();
				countTrucks++;
			}
		}
		System.out.println("Your average rating is" + sum / countTrucks);
	}

	private void highestRating(FoodTruck[] trucks) {
		double countTrucks = 0;
//		for(int num : numbers) {
//			if(num > max) {
//				max = num;
//			}
//		}
//		if(numbers[i] > max) {
//			max = numbers[i];
//		}

		FoodTruck forRatings = null;
		double highest = 0;
		for (int i = 0; i < trucks.length; i++) {
			if (trucks[i] != null) {
				if (trucks[i].getRating() > highest) {
					highest = trucks[i].getRating();
					forRatings = trucks[i];
				}
			}
		}
		forRatings.displayTruck();
	}

	private FoodTruck buildUserTruck(Scanner scanner) {
		System.out.println("Enter in the name of your first truck: ");
		String truckName = scanner.nextLine();
		System.out.println("Enter in the food type of this truck: ");
		String foodType = scanner.nextLine();
		System.out.println("Enter in the food rating from 1 to 5: ");
		double rating = scanner.nextDouble();
//		displayUserRating(rating);
		scanner.nextLine();
		FoodTruck truck = new FoodTruck(truckName, foodType, rating);
		return truck;
	}

	private void displayUserRating(int rating) {
		switch (rating) {
		case 0:
			System.out.println("You have given this food truck 0 out of 5 stars.");
			break;
		case 1:
			System.out.println("You have given this food truck 1 out of 5 stars.");
			break;
		case 2:
			System.out.println("You have given this food truck 2 out of 5 stars.");
			break;
		case 3:
			System.out.println("You have given this food truck 3 out of 5 stars.");
			break;
		case 4:
			System.out.println("You have given this food truck 4 out of 5 stars.");
			break;
		case 5:
			System.out.println("You have given this food truck 5 out of 5 stars.");
			break;
		default:
			break;
		}
	}

	private FoodTruck[] getTestTruckArr() {
		FoodTruck truck1 = new FoodTruck();
		truck1.setTruckName("house");
		truck1.setFoodType("pancackes");
		truck1.setRating(4);

		FoodTruck truck2 = new FoodTruck();
		truck2.setTruckName("turf");
		truck2.setFoodType("SeasFood");
		truck2.setRating(2);

		FoodTruck truck3 = new FoodTruck();
		truck3.setTruckName("Food");
		truck3.setFoodType("Mexican Style");
		truck3.setRating(5);
		FoodTruck[] truckArr = { truck1, truck2, truck3 };
		return truckArr;
	}
}