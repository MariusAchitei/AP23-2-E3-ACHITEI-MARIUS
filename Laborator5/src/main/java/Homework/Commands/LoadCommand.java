package Homework.Commands;

import Homework.Catalog;
import Homework.InvalidCatalogException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class LoadCommand implements Command {
    private String path;

    public LoadCommand(String path) {
        this.path = path;
    }

    public void execute(Catalog catalog) throws InvalidCatalogException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            catalog = objectMapper.readValue(
                    new File(path),
                    Catalog.class);
        } catch (Exception e) {
            throw new InvalidCatalogException("NU A MERS COMANDA VERIC\n", e);
        }
    }
}
