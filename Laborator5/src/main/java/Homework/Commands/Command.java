package Homework.Commands;

import Homework.Catalog;
import Homework.Document;
import Homework.InvalidCatalogException;

import java.io.IOException;

public interface Command {
    void execute(Catalog catalog) throws InvalidCatalogException;
}
