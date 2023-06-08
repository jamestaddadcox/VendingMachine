package com.techelevator;

public class MainMenu {
    private UI ui = new UI();
    private Inventory inventory = new Inventory();
    private PurchaseMenu purchaseMenu = new PurchaseMenu();

public MainMenu(Inventory inventory){
    this.inventory = inventory;
}
    public void runMainMenu() {
    ui.displayMainMenu();
    String mainMenuInput = ui.getMainMenuInput();
		if (mainMenuInput.equals("1")) {
            for (String slotLocation : inventory.getInventoryMap().keySet()) {
                Item item = inventory.getInventoryMap().get(slotLocation);
                System.out.println(slotLocation + " | " + item.getName() + " | " + inventory.getInventoryMap().get(slotLocation).getPrice()+ " | " + inventory.getInventoryMap().get(slotLocation).getQuantity());
            }
        } if (mainMenuInput.equals("2")) {


        }
    }


}
