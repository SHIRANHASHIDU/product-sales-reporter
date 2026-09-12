package com.salesreporter.io;

import com.salesreporter.model.Product;
import java.util.List;
import java.io.IOException;

public interface SalesDataReader {
    List<Product> readSalesData(String filePath) throws IOException;
}
