package Homework.Commands;

import Homework.Catalog;
import Homework.Document;

import java.io.IOException;

public interface Command {
    void execute(Catalog catalog) throws IOException;
}
