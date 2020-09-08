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
		buildUserTruck(scanner, trucks);
//		trucks = getTestTruckArr();
		boolean keepGoing = true;
		while (keepGoing) {
			System.out.println("       __________________________________________________ ");
			System.out.println("      |                                                  |");
			System.out.println("      |   Which truck details would you like to view?    |");
			System.out.println("   ___|                                                  |___");
			System.out.println("  |              1) Print trucks                             |");
			System.out.println("  |              2) Get average ratings                      |");
			System.out.println("  |              3) Get highest-rated truck                  |");
			System.out.println("  |              4) Quit                                     |");
			System.out.println("  |__________________________________________________________|");
			String user = scanner.nextLine();
			switch (user) {
			case "1":
				printTruck(trucks);
				break;
			case "2":
				averageRating(trucks);
				break;
			case "3":
				highestRating(trucks);
				break;
			case "4":
				System.out.println("Have a good day!");
				keepGoing = false;
				break;
			default:
				break;
			}

		}

//		printTruck(trucks);
//		averageRating(trucks);
//		highestRating(trucks);
	}

	private void printTruck(FoodTruck[] trucks) {
		for (int i = 0; i < trucks.length; i++) {
			if (trucks[i] != null) {
				trucks[i].displayTruck();
			}
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
		System.out.println("Your average rating is " + sum / countTrucks);
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

	private void buildUserTruck(Scanner scanner, FoodTruck[] trucks) {
		for (int i = 0; i < trucks.length; i++) {
			System.out.println("Enter in the truck name: ");
			String truckName = scanner.nextLine();

			if (truckName.equals("quit")) {
				break;
			}
			System.out.println("Enter in the food type of this truck: ");
			String foodType = scanner.nextLine();
			System.out.println("Enter in the food rating from 1 to 5: ");
			double rating = scanner.nextDouble();
//		displayUserRating(rating);
			scanner.nextLine();
			FoodTruck truck = new FoodTruck(truckName, foodType, rating);
			trucks[i] = truck;
		}
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