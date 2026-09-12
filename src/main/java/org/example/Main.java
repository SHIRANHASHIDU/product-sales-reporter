// SalesDataReader.java
package com.salesreporter.io;

import com.salesreporter.model.Product;
import java.io.IOException;
import java.util.List;

public interface SalesDataReader {
    List<Product> readSalesData(String filePath) throws IOException;
}