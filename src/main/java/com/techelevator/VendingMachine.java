package com.techelevator;

public class VendingMachine {

	private UI ui = new UI();
	private MainMenu mainMenu = new MainMenu();

	private String INVENTORY_FILE_NAME = "vendingmachine.csv";
	private int MAX_ITEM_AMOUNT = 5;



	public static void main(String[] args) {
		VendingMachine vendingMachine = new VendingMachine();
		vendingMachine.run();

	}




	private void run() {
		InventoryCreator inventoryCreator = new InventoryCreator();
		Inventory inventory = inventoryCreator.createInventory(INVENTORY_FILE_NAME, MAX_ITEM_AMOUNT);

		System.out.println(inventory.getBalance());
		inventory.addMoneyToBalance(14);
		System.out.println(inventory.getBalance());
		System.out.println(inventory.getInventoryMap().get("A1"));



		// run menu
		mainMenu.runMainMenu();

	}

}
