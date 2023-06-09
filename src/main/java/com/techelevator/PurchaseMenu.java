package com.techelevator;


public class PurchaseMenu {
    Inventory inventory;

    UI ui = new UI();

    public PurchaseMenu(Inventory inventory) {
        this.inventory = inventory;
    }

    public void runPurchaseMenu() {
        String purchaseMenuInput;

        do {

            ui.displayPurchaseMenu();
            purchaseMenuInput = ui.getPurchaseMenuInput();

            if (purchaseMenuInput.equals("1")) {

                ui.displayFeedMoney();
                String feedMoneyInput = ui.getFeedMoneyInput();
                if (feedMoneyInput.contains(".")) {
                    String moneyAsWhole = feedMoneyInput.replace(".", "");
                    int moneyInput = Integer.parseInt(moneyAsWhole);
                    inventory.addMoneyToBalance(moneyInput);

                } else {
                    int moneyInput = Integer.parseInt(feedMoneyInput);
                    inventory.addMoneyToBalance(moneyInput * 100);


                    //System.out.println("New balance is: " + inventory.getBalance());
                }
            }
            if (purchaseMenuInput.equals("2")) {

                ui.displayPurchaseProduct();


            }

            if (purchaseMenuInput.equals("3")) {
                ui.change(inventory.getBalance());


            }

        } while (!purchaseMenuInput.equals(3));
    }
}



