package homework.commands;

import homework.Catalog;
import homework.InvalidCatalogException;

public interface Command {
    void execute(Catalog catalog) throws InvalidCatalogException;
}
