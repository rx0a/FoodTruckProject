package com.skilldistillery.app;

import java.util.Scanner;

public class FoodTruckApp {
	FoodTruck[] foodTrucks;

	public static void main(String[] args) {
		FoodTruckApp run = new FoodTruckApp();
		Scanner kb = new Scanner(System.in).useDelimiter("\n");

		run.displayGreeting();
		run.addFoodTruck(kb);
		run.mainMenu(kb);
	}

	public void displayGreeting() {
		System.out.println("|--------------------------|");
		System.out.println("|   FoodTruck Rating App   |");
		System.out.println("|--------------------------|");
		System.out.println("| • Enter up to 5 trucks.  |");
		System.out.println("| • Type \"quit\" when done. |");
	}

	public void mainMenu(Scanner kb) {
		System.out.println("|--------------------------|");
		System.out.println("|        Main Menu         |");
		System.out.println("|--------------------------|");
		System.out.println("| [1] List all foodtrucks  |");
		System.out.println("| [2] See average ratings  |");
		System.out.println("| [3] See highest rating   |");
		System.out.println("| [4] Quit                 |");
		System.out.println("|--------------------------|");
		System.out.print("|  > ");

		boolean repeat = true;

		do {
			int menu = kb.nextInt();
			switch (menu) {
			case 1:
				listFoodTrucks(foodTrucks);
				break;
			case 2:
				averageRate(foodTrucks);
				break;
			case 3:
				highestRate(foodTrucks);
				break;
			case 4:
				displayGoodbye();
				break;
			default:
				displayError();
			}

		} while (repeat);
	}

	public void addFoodTruck(Scanner kb) {
		this.foodTrucks = new FoodTruck[10];

		for (int i = 0; i < 5; i++) {

			System.out.println("|--------------------------|");
			System.out.println("| Enter name of foodtruck  |");
			System.out.println("| \t     #" + (i + 1) + "     \t   |");
			System.out.print("|  > ");
			String name = kb.next();

			if (name.equalsIgnoreCase("quit")) {
				break;
			}

			System.out.println("|--------------------------|");
			System.out.println("| Enter type of foodtruck  |");
			System.out.println("| \t     #" + (i + 1) + "     \t   |");
			System.out.print("|  > ");
			String type = kb.next();

			System.out.println("|--------------------------|");
			System.out.println("| Rate foodtruck   [1] low |");
			System.out.println("|       #" + (i + 1) + " \t   [5] High|");
			System.out.print("|  > ");
			double rating = kb.nextInt();
			if (rating > 5 || rating < 1) {
				System.out.println("| Number not within limit. |");
				System.out.println("|       Restarting...      |");
				addFoodTruck(kb);
			}

			foodTrucks[i] = new FoodTruck(name, type, rating);
			System.out.println("| FoodTruck " + foodTrucks[i].getTruckName() + " created! ");

			if (i == 4) {
				continue;
			}
		}
	}

	public void listFoodTrucks(FoodTruck foodTrucks[]) {
		Scanner kb = new Scanner(System.in);

		int i = 0;
		System.out.println("|---------------------------------------------------| ");

		while (foodTrucks[i] != null && i < 6) {
			// System.out.println("");
			System.out.println("| " + foodTrucks[i].toString());
			i++;
		}
		System.out.println("|---------------------------------------------------| ");
		System.out.println("| Enter \"m\" for menu.      |");
		System.out.print("|  > ");
		String menu = kb.nextLine();
		if (menu.equalsIgnoreCase("m")) {
			mainMenu(kb);
		}
	}

	public void highestRate(FoodTruck foodTrucks[]) {
		Scanner kb = new Scanner(System.in);

		int i = 0;
		int index = 0;
		double rate = foodTrucks[0].getTruckRating();
		while (foodTrucks[i] != null && i < 6) {
			if (foodTrucks[i].getTruckRating() > rate) {
				rate = foodTrucks[i].getTruckRating();
				index = i;
			}
			i++;
		}
		System.out.println("|---------------------------------------------------| ");
		System.out.println("| " + foodTrucks[index]);
		System.out.println("|---------------------------------------------------| ");
		System.out.println("| Enter \"m\" for menu.      |");
		System.out.print("|  > ");
		String menu = kb.nextLine();
		if (menu.equalsIgnoreCase("m")) {
			mainMenu(kb);
		}
	}

	public void averageRate(FoodTruck foodTrucks[]) {
		Scanner kb = new Scanner(System.in);

		int i = 0;
		double totalRate = 0;
		while (foodTrucks[i] != null && i < 6) {
			totalRate += foodTrucks[i].getTruckRating();
			i++;
		}
		double averageRate = totalRate / i;
		System.out.println("|--------------------------|");
		System.out.println("| Average rating is: " + averageRate);
		System.out.println("|--------------------------|");
		System.out.println("| Enter \"m\" for menu.      |");
		System.out.print("|  > ");
		String menu = kb.nextLine();
		if (menu.equalsIgnoreCase("m")) {
			mainMenu(kb);
		}
	}

	public void displayGoodbye() {
		System.out.println("|--------------------------|");
		System.out.println("|         Goodbye!         |");
		System.out.println("|--------------------------|");
	}

	public void displayError() {
		System.out.println("|--------------------------|");
		System.out.println("|       Invalid Input.     |");
		System.out.println("|--------------------------|");
	}
}
