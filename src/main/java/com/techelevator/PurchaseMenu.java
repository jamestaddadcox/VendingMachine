package com.techelevator;


import java.text.NumberFormat;

public class PurchaseMenu {
    Inventory inventory;
    UI ui;

    public PurchaseMenu(Inventory inventory) {
        this.inventory = inventory;
        ui = new UI(inventory);

    }

    public void runPurchaseMenu() {
        String purchaseMenuInput;

        do {

            ui.displayPurchaseMenu();
            purchaseMenuInput = ui.getPurchaseMenuInput();

            if (purchaseMenuInput.equals("1")) {

                ui.displayFeedMoney();


                    //System.out.println("New balance is: " + inventory.getBalance());
                }

            if (purchaseMenuInput.equals("2")) {

                ui.displayPurchaseProduct();


            }

            if (purchaseMenuInput.equals("3")) {
                ui.change(inventory.getBalance());


            }

        } while (!purchaseMenuInput.equals("3"));
    }


}



