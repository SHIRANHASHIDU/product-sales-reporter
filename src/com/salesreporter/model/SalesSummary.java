package com.salesreporter.model;

import java.util.List;
import java.util.Map;

public class SalesSummary {

    // Resolves getProducts()
    public List<com.salesreporter.model.Product> getProducts() {
        return null; // Implement your logic to return the list
    }

    // Resolves getCategoryRevenues()
    public Map<String, Double> getCategoryRevenues() {
        return null; // Implement logic to return category mapped to revenue
    }

    // Resolves getBestSellingProduct()
    public com.salesreporter.model.Product getBestSellingProduct() {
        return null; // Implement logic to return top product by quantity
    }

    // Resolves getHighestRevenueProduct()
    public com.salesreporter.model.Product getHighestRevenueProduct() {
        return null; // Implement logic to return top product by revenue
    }

    // Resolves getGrandTotalRevenue()
    public double getGrandTotalRevenue() {
        return 0.0; // Implement logic to return the total sum
    }
}