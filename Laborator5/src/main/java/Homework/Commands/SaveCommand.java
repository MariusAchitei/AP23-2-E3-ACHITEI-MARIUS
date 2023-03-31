package Homework.Commands;

import Homework.Catalog;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class SaveCommand implements Command {
    String path;

    public SaveCommand(String path) {
        this.path = path;
    }

    public void execute(Catalog catalog) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(
                new File(path),
                catalog);
    }
}
