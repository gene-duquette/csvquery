package com.duquette.tool.csvquery;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;

/**
 * Simple file loader iterates CSV file rows.  The first row returned is the header.
 */
public class CSVLoader implements Iterable<CSVRow>, Iterator<CSVRow> {
    private final BufferedReader reader;
    private String currentLine = null;

    public CSVLoader(File file) throws FileNotFoundException {
        this.reader = new BufferedReader(new FileReader(file));
    }

    public CSVLoader(final Reader reader) {
        this.reader = new BufferedReader(reader);
    }

    @Override
    public Iterator<CSVRow> iterator() {
        return this;
    }

    @Override
    public boolean hasNext() {
        try {
            this.currentLine = reader.readLine();
        } catch ( IOException e ) {
            throw new CSVLoaderException(e);
        }
        return currentLine != null;
    }

    @Override
    public CSVRow next() {
        return new CSVRow(this.currentLine);
    }
}
