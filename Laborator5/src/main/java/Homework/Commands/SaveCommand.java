package homework.commands;

import homework.Catalog;
import homework.InvalidCatalogException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class SaveCommand implements Command {
    String path;

    public SaveCommand(String path) {
        this.path = path;
    }

    public void execute(Catalog catalog) throws InvalidCatalogException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(
                    new File(path),
                    catalog);
        }catch (Exception e){
            throw new InvalidCatalogException("Nu a mers save u verisor", e);
        }

    }
}
