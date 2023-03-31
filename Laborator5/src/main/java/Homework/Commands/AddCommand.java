package homework.commands;

import homework.Catalog;
import homework.Document;
import homework.InvalidCatalogException;

public class AddCommand implements Command {
    private Document document;

    public AddCommand(Document document) {
        this.document = document;
    }

    public void execute(Catalog catalog) throws InvalidCatalogException {
        catalog.add(document);
    }

//    public void execute(Catalog catalog, String path) {
//
//    }
}
