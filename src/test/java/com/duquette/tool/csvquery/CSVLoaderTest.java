package com.duquette.tool.csvquery;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.StringReader;
import java.io.IOException;
import java.io.Reader;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CSVLoaderTest {
    @Test public void testCSVLoad() {
        String data = "Hello, World";
        Reader reader = new StringReader(data);
        CSVRow testRow = new CSVRow(data);

        final CSVLoader loader = new CSVLoader(reader);
        
        assertTrue(loader.hasNext());
        CSVRow loaderRow = loader.next();
        assertEquals(testRow, loaderRow);
        assertEquals(loaderRow.size(), 2);
        assertFalse(loader.hasNext());
    }
}
