// ReportFormatter.java
package com.salesreporter.formatter;

import com.salesreporter.model.Product;
import com.salesreporter.model.SalesSummary;
import java.util.Map;

public class ReportFormatter {

    public String format(SalesSummary summary) {
        StringBuilder sb = new StringBuilder();
        sb.append("============================================\n");
        sb.append("        PRODUCT SALES SUMMARY REPORT        \n");
        sb.append("============================================\n\n");

        sb.append("--- Revenue Per Product ---\n");
        for (Product p : summary.getProducts()) {
            sb.append(String.format("%-6s %-18s %-14s $ %8.2f\n",
                    p.getId(), p.getName(), p.getCategory(), p.calculateRevenue()));
        }
        sb.append("\n");

        sb.append("--- Revenue Per Category ---\n");
        for (Map.Entry<String, Double> entry : summary.getCategoryRevenues().entrySet()) {
            sb.append(String.format("%-14s : $ %8.2f\n", entry.getKey(), entry.getValue()));
        }
        sb.append("\n");

        sb.append("--- Highlights ---\n");
        sb.append(String.format("Best-Selling Product : %s (%d units)\n",
                summary.getBestSellingProduct().getName(),
                summary.getBestSellingProduct().getQuantitySold()));
        sb.append(String.format("Highest Revenue      : %s ($ %.2f)\n",
                summary.getHighestRevenueProduct().getName(),
                summary.getHighestRevenueProduct().calculateRevenue()));
        sb.append(String.format("Grand Total Revenue  : $ %.2f\n",
                summary.getGrandTotalRevenue()));
        sb.append("============================================\n");

        return sb.toString();
    }
}