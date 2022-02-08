package com.duquette.tool.csvquery;

import org.apache.logging.log4j.util.Strings;

/**
 * Represents a single row in the CSV file.
 */
public class CSVRow {
    private final String[] row;
    private final String line;

    public CSVRow(String line) {
        if ( Strings.isBlank(line) ) {
            throw new IllegalArgumentException("Line must contain data.");
        }
        
        row = line.trim().split("\\s*,\\s*");
        this.line = line;
    }

    public String[] getRow() {
        return row;
    }

    public int size() {
        return row.length;
    }

    @Override
    public String toString() {
        return line;    
    }

    @Override
    public boolean equals(Object obj) {
        try {
            return ((CSVRow)obj).line.equals(line);
        } catch ( Exception e ) {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return this.line.hashCode();
    }
}
