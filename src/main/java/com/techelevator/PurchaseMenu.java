package com.techelevator;


public class PurchaseMenu {
    UI ui = new UI();
    Inventory inventory = new Inventory();
    public PurchaseMenu(UI ui, Inventory inventory) {
        this.ui = ui;
        this.inventory = inventory;
    }
    public void runPurchaseMenu() {
        ui.displayPurchaseMenu(inventory);

    }
}
