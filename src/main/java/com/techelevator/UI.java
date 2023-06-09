package com.techelevator;

import java.text.NumberFormat;
import java.util.Scanner;

public class UI {
Inventory inventory = new Inventory();
    private Scanner userInput = new Scanner(System.in);
    String formattedAmount;// format amount as money

public UI(Inventory inventory) {
    this.inventory = inventory;
}

    public void displayMainMenu() {
        System.out.println("Please choose from the following options: ");
        System.out.println("\n(1) Display Vending Machine Items");
        System.out.println("(2) Purchase");
        System.out.println("(3) Exit");
    }

    public String getMainMenuInput() {
        return userInput.nextLine();
    }

    public void displayPurchaseMenu() {

        System.out.println("Current money provided: " + priceConverter(inventory.getBalance()));
        System.out.println("\nPlease choose from the following options: ");
        System.out.println("\n(1) Feed Money");
        System.out.println("(2) Select Product");
        System.out.println("(3) Finish Transaction");
    }


    public String getPurchaseMenuInput() {
        return userInput.nextLine();
    }

    public void displayFeedMoney() {
        System.out.println("Current money provided: " + priceConverter(inventory.getBalance()));
        System.out.println("Please enter in the dollar amount: ");


    }

    public String getFeedMoneyInput() {
        return userInput.nextLine();
    }


    public void displayPurchaseProduct() {

        for (String location : inventory.getInventoryMap().keySet()) {
            if (inventory.getInventoryMap().get(location).getQuantity() > 0) {
                System.out.println(location + ", " + inventory.getInventoryMap().get(location).getName() + ", " + priceConverter(inventory.getInventoryMap().get(location).getPrice()) + ", " + inventory.getInventoryMap().get(location).getQuantity());
            } else {
                System.out.println(location + ", " + inventory.getInventoryMap().get(location).getName() + ", " + priceConverter(inventory.getInventoryMap().get(location).getPrice()) + ", " + "OUT OF STOCK");
            }
        }
            System.out.println("Please select which item you would like to purchase: ");
            String locationNumber = userInput.nextLine();

            inventory.makePurchase(locationNumber);

            System.out.println("Dispensing " + inventory.getInventoryMap().get(locationNumber).getName());

            if (inventory.getInventoryMap().get(locationNumber).getType().equals("Candy")) {
                System.out.println("Munch Munch, Yum!");
            } else if (inventory.getInventoryMap().get(locationNumber).getType().equals("Chip")) {
                System.out.println("Crunch Crunch, Yum!");
            } else if (inventory.getInventoryMap().get(locationNumber).getType().equals("Drink")) {
                System.out.println("Glug Glug, Yum!");
            } else if (inventory.getInventoryMap().get(locationNumber).getType().equals("Gum")) {
                System.out.println("Chew Chew, Yum!");
            }

        }


        public void change (int balance){
            int quarters = balance / 25;
            balance %= 25;


            int dimes = balance / 10;
            balance %= 10;


            int nickles = balance / 5;


            System.out.println("Your balance of " + priceConverter(inventory.getBalance()) + " will be returned as following: ");
            System.out.println("Quarters: " + quarters + ", Dimes: " + dimes + ", Nickles: " + nickles );
            System.out.println("Thank you for your purchase!");


        }

    public String priceConverter(int price) {
        String formattedAmount = NumberFormat.getCurrencyInstance().format((double) price / 100);
        return formattedAmount;
    }

}
