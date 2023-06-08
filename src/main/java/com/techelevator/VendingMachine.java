package com.techelevator;

public class VendingMachine {




	private String INVENTORY_FILE_NAME = "vendingmachine.csv";
	private int MAX_ITEM_AMOUNT = 5;



	public static void main(String[] args) {
		VendingMachine vendingMachine = new VendingMachine();
		vendingMachine.run();

	}




	private void run() {
		InventoryCreator inventoryCreator = new InventoryCreator();
		Inventory inventory = inventoryCreator.createInventory(INVENTORY_FILE_NAME, MAX_ITEM_AMOUNT);
		MainMenu mainMenu = new MainMenu(inventory);



		// run menu
		mainMenu.runMainMenu();


	}

}
