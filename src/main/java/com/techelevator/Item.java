package com.techelevator;

public class Item {
    private String name;
    private String location;
    private int price;
    private String type;        // Drink, Candy, Chip, Gum

    public Item(String name, String location, int price, String type) {
        this.name = name;
        this.location = location;
        this.price = price;
        this.type = type;
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
}
