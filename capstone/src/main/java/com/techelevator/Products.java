package com.techelevator;

public abstract class Products {

    //variables
    private String name;
    private double price;
    private String getMessage;

    //constructors
    public Products(String name, double price) {
        this.name = name;
        this.price = price;
    }

    //getters
    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public abstract String getMessage();


    //setters
    private void setName(String name) {
        this.name = name;
    }

    private void setPrice(double price) {
        this.price = price;
    }
}
