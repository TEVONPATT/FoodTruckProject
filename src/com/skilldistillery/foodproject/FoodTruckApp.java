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
		boolean keepGoing = true;
		while (keepGoing) {
			System.out.println("       __________________________________________________ ");
			System.out.println("      |                                                  |");
			System.out.println("      |       Which action would you like to take?       |");
			System.out.println("   ___|  ______________________________________________  |___");
			System.out.println("   ||                                                      ||");
			System.out.println("   ||              1) Print trucks                         ||");
			System.out.println("   ||              2) Get average truck rating             ||");
			System.out.println("   ||              3) Get highest-rated truck              ||");
			System.out.println("   ||              4) Quit                                 ||");
			System.out.println("   ||         ____________________________________         ||");
			System.out.println("   ||______________________________________________________||");
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
			scanner.nextLine();
			FoodTruck truck = new FoodTruck(truckName, foodType, rating);
			trucks[i] = truck;
		}
	}
}