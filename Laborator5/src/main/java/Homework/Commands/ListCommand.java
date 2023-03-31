package Homework.Commands;

import Homework.Catalog;
import Homework.InvalidCatalogException;

import java.io.IOException;

public class ListCommand implements Command {

    @Override
    public void execute(Catalog catalog) throws InvalidCatalogException {
        System.out.println(catalog.toString());
    }
}
