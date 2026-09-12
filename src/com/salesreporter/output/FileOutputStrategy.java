package com.salesreporter.output;

public class FileOutputStrategy implements ReportOutputStrategy {
    private String filePath;

    public FileOutputStrategy(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void writeReport(String reportContent) {
        // Implement file writing logic here
    }
}
