package com.salesreporter.output;

public class ConsoleOutputStrategy implements ReportOutputStrategy {
    @Override
    public void writeReport(String reportContent) {
        System.out.println(reportContent);
    }
}
