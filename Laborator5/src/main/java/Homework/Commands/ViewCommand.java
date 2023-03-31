package Homework.Commands;

import Homework.Catalog;
import Homework.Document;
import Homework.InvalidCatalogException;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.lang.Object;


public class ViewCommand implements Command {
    private int id;

    public ViewCommand(int id) {
        this.id = id;
    }

    @Override
    public void execute(Catalog catalog) throws InvalidCatalogException {
        try {
            Document document = catalog.findById(id);
            if (document == null)
                return;
//        String path =
            Desktop desktop = Desktop.getDesktop();
            desktop.open(new File(document.getPath()));
        } catch (Exception e) {
            throw new InvalidCatalogException("Eroare la View", e);
        }
    }
}