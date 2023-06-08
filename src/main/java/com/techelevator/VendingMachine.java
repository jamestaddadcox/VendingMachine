package com.techelevator;

public class VendingMachine {

<<<<<<< HEAD
	private UI ui = new UI();
	private MainMenu mainMenu = new MainMenu();
=======
	private String INVENTORY_FILE_NAME = "vendingmachine.csv";
	private int MAX_ITEM_AMOUNT = 5;



>>>>>>> 206a9959fd6de52aaf2e7796f265b84c6f50d9a9
	public static void main(String[] args) {
		VendingMachine vendingMachine = new VendingMachine();
		vendingMachine.run();

	}

<<<<<<< HEAD
	public void run() {
		// create inventory
		Inventory inventory = new Inventory();
=======
	private void run() {
		InventoryCreator inventoryCreator = new InventoryCreator();
		Inventory inventory = inventoryCreator.createInventory(INVENTORY_FILE_NAME, MAX_ITEM_AMOUNT);

		System.out.println(inventory.getBalance());

>>>>>>> 206a9959fd6de52aaf2e7796f265b84c6f50d9a9

		// run menu
		mainMenu.runMainMenu();

	}

}
