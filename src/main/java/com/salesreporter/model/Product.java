package com.salesreporter.model;

public class Product {
    private final String id;
    private final String name;
    private final String category;
    private final int quantitySold;
    private final double unitPrice;

    public Product(String id, String name, String category, int quantitySold, double unitPrice) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.quantitySold = quantitySold;
        this.unitPrice = unitPrice;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public int getQuantitySold() { return quantitySold; }
    public double getUnitPrice() { return unitPrice; }

    public double calculateRevenue() {
        return quantitySold * unitPrice;
    }
}