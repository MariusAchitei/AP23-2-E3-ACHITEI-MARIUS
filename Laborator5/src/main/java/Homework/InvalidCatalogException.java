package Homework;

import java.io.IOException;
import java.sql.SQLOutput;

public class InvalidCatalogException extends Exception {

    public InvalidCatalogException(String message, Exception e) {
        super(message);
    }
}
