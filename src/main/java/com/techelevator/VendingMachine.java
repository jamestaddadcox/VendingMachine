package com.techelevator;

public class VendingMachine {

	private UI ui = new UI();
	private MainMenu mainMenu = new MainMenu();
	public static void main(String[] args) {
		VendingMachine vendingMachine = new VendingMachine();
		vendingMachine.run();

	}

	public void run() {
		// create inventory
		Inventory inventory = new Inventory();

		// run menu
		mainMenu.runMainMenu();

	}

}
