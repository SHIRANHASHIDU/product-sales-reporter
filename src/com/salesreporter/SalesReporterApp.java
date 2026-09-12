// SalesReporterApp.java (Main Entry Point)
package com.salesreporter;

import com.salesreporter.formatter.ReportFormatter;
import com.salesreporter.io.CsvSalesDataReader;
import com.salesreporter.io.SalesDataReader;
import com.salesreporter.model.Product;
import com.salesreporter.model.SalesSummary;
import com.salesreporter.output.ConsoleOutputStrategy;
import com.salesreporter.output.FileOutputStrategy;
import com.salesreporter.output.ReportOutputStrategy;
import com.salesreporter.service.SalesReportService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class SalesReporterApp {

    public static void main(String[] args) {
        if (args.length < 2) {
            printUsageAndExit("Error: Missing required arguments.");
            return;
        }

        String inputFilePath = args[0];
        String outputMethod = args[1].toLowerCase();
        String outputFilePath = (args.length >= 3) ? args[2] : null;

        ReportOutputStrategy outputStrategy;
        if ("console".equals(outputMethod)) {
            outputStrategy = new ConsoleOutputStrategy();
        } else if ("file".equals(outputMethod)) {
            if (outputFilePath == null || outputFilePath.trim().isEmpty()) {
                printUsageAndExit("Error: Output file path is required when com.salesreporter.output-method is 'file'.");
                return;
            }
            outputStrategy = new FileOutputStrategy(outputFilePath);
        } else {
            printUsageAndExit("Error: Invalid com.salesreporter.output method '" + outputMethod + "'. Must be 'console' or 'file'.");
            return;
        }

        try {
            SalesDataReader dataReader = new CsvSalesDataReader();
            List<Product> products = dataReader.readSalesData(inputFilePath);

            if (products.isEmpty()) {
                System.err.println("Warning: CSV file contains no product records.");
                return;
            }

            SalesReportService reportService = new SalesReportService();
            SalesSummary summary = reportService.generateSummary(products);

            ReportFormatter formatter = new ReportFormatter();
            String formattedReport = formatter.format(summary);

            outputStrategy.writeReport(formattedReport);

        } catch (FileNotFoundException e) {
            System.err.println("Error: Input CSV file was not found at path: " + inputFilePath);
        } catch (IllegalArgumentException e) {
            System.err.println("Validation Error: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("I/O Error occurred while processing files: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    private static void printUsageAndExit(String errorMessage) {
        System.err.println(errorMessage);
        System.err.println("Usage: java SalesReporterApp <csv-file-path> <console|file> [com.salesreporter.output-file-path]");
    }
}