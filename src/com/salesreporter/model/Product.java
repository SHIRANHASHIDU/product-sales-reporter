package com.salesreporter.model;

public class Product {
    private String id;
    private String name;
    private String category;
    private int quantitySold;
    private double price;

    // You will need a constructor here to initialize these fields

    public String getId() { return id; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public int getQuantitySold() { return quantitySold; }

    // This resolves the 'calculateRevenue()' error
    public double calculateRevenue() {
        return quantitySold * price;
    }
}
