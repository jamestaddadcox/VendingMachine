package com.techelevator;

import java.text.NumberFormat;
import java.util.Objects;

public class MainMenu {
    private Inventory inventory;
    private UI ui;
    private PurchaseMenu purchaseMenu;


    public MainMenu(Inventory inventory){
    this.inventory = inventory;
    purchaseMenu = new PurchaseMenu(inventory);
    ui = new UI(inventory);
}
    public void runMainMenu() {
        String mainMenuInput;
        do {
            System.out.println("");
            ui.displayMainMenu();
            mainMenuInput = ui.getMainMenuInput();

            if (mainMenuInput.equals("1")) {
                for (String slotLocation : inventory.getInventoryMap().keySet()) {
                    Item item = inventory.getInventoryMap().get(slotLocation);
                    System.out.println(slotLocation + ", " + item.getName() + ", " + priceConverter(inventory.getInventoryMap().get(slotLocation).getPrice()) + ", " + inventory.getInventoryMap().get(slotLocation).getQuantity());
                }
            }
            if (mainMenuInput.equals("2")) {
                purchaseMenu.runPurchaseMenu();
            }

        } while (!mainMenuInput.equals("3"));
    }


    public String priceConverter(int price) {

        String formattedAmount = NumberFormat.getCurrencyInstance().format(price); // format amount as money
        return formattedAmount;
        }

    }


