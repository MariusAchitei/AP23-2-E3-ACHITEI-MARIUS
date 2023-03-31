package Homework.Commands;

import Homework.Catalog;
import Homework.Document;

import java.io.IOException;
import java.util.Calendar;

public class AddCommand implements Command {
    private Document document;

    public AddCommand(Document document) {
        this.document = document;
    }

    public void execute(Catalog catalog) throws IOException {
        catalog.add(document);
    }

//    public void execute(Catalog catalog, String path) {
//
//    }
}
