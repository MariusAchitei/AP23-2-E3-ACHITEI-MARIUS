package homework.commands;

import homework.Catalog;
import homework.InvalidCatalogException;

public class ListCommand implements Command {

    @Override
    public void execute(Catalog catalog) throws InvalidCatalogException {
        System.out.println(catalog.toString());
    }
}
