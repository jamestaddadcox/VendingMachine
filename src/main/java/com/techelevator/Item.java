package com.techelevator;

public class Item {
    private String name;
    private String location;
    private int price;
    private String type;        // Drink, Candy, Chip, Gum
    private int quantity;
    private int STARTING_ITEM_AMOUNT = 5;

    public Item(String name, String location, int price, String type) {
        this.name = name;
        this.location = location;
        this.price = price;
        this.type = type;
        quantity = STARTING_ITEM_AMOUNT;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
