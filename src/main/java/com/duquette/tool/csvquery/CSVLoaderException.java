package com.duquette.tool.csvquery;

public class CSVLoaderException extends RuntimeException {
    CSVLoaderException(Exception e) {
        super(e);
    }
}
