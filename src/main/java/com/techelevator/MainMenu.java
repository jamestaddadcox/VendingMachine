package com.techelevator;

public class MainMenu {

    private PurchaseMenu purchaseMenu = new PurchaseMenu();


    public void runMainMenu() {
    ui.displayMainMenu();
    String mainMenuInput = ui.getMainMenuInput();
		if (mainMenuInput.equals("1")) {
            for (String slotLocation : inventory.getInventoryMap.getValue()) {
                System.out.println(slotLocation + " | " + inventory.getInventoryMap.get(slotLocation).getName + " | " + inventory.getInventoryMap.get(slotLocation).getPrice + " | " + inventory.getInventoryMap.get(slotLocation).getQuantity);
            }
        } if (mainMenuInput.equals("2")) {


        }
    }


}
