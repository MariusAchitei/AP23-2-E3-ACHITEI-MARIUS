package Homework.Commands;

import Homework.Catalog;

import java.io.IOException;

public class ListCommand implements Command {

    @Override
    public void execute(Catalog catalog) throws IOException {
        System.out.println(catalog.toString());
    }
}
