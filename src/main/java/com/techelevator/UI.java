package com.techelevator;

import java.util.Scanner;

public class UI {

private Scanner userInput = new Scanner(System.in);


    public void displayMainMenu() {
        System.out.println("Please choose from the following options: ");
        System.out.println("\n(1) Display Vending Machine Items");
        System.out.println("(2) Purchase");
        System.out.println("(3) Exit");
    }

    public String getMainMenuInput() {
        return userInput.nextLine();
    }

    public void displayPurchaseMenu(Inventory inventory) {
        System.out.println("Current Money Provided: " + inventory.getBalance());
        System.out.println("\nPlease choose from the following options: ");
        System.out.println("\n(1) Feed Money");
        System.out.println("(2) Select Product");
        System.out.println("(3) Finish Transaction");
    }

}
