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

}
