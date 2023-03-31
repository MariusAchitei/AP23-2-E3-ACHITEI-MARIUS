package homework;

public class InvalidCatalogException extends Exception {

    public InvalidCatalogException(String message, Exception e) {
        super(message);
    }
}
