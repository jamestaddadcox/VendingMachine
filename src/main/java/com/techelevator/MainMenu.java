package com.techelevator;

import java.text.NumberFormat;
import java.util.Objects;

public class MainMenu {
    private UI ui = new UI();
    private Inventory inventory = new Inventory();
    private PurchaseMenu purchaseMenu = new PurchaseMenu(ui, inventory);

public MainMenu(Inventory inventory){
    this.inventory = inventory;
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

        } while (mainMenuInput.equals("1"));
    }


    public String priceConverter(int price) {

        String formattedAmount = NumberFormat.getCurrencyInstance().format((double)price / 100); // format amount as money
        return formattedAmount;
        }

    }


