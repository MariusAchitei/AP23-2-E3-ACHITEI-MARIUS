package homework;

import homework.commands.Command;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Catalog implements Serializable {
    private String name;
    private List<Document> documents;

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    public Catalog() {
    }

    ;

    public Catalog(String name) {
        documents = new LinkedList<>();
        this.name = name;
    }

    public Catalog(String name, List<Document> documents) {
        this.documents = documents;
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void add(Document document) {

        documents.add(document);
    }

    public void execute(Command command) {
        try {
            command.execute(this);
        } catch (InvalidCatalogException e) {
            System.out.println(e.getMessage());
        }
    }

//    public void execute(Command command, String path) {
//        command.execute(this, path);
//    }
//    public void execute(Command command, Document document) {
//        command.execute(this, document);
//    }

    public Document findById(int id) {
        for (var document :
                documents) {
            if (document.getId() == id)
                return document;
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("Nume:" + this.name + "\n" + "Elemente:" + "\n");
        for (Document document :
                documents) {
            string.append(document.toString());
            string.append("\n");
        }
        return string.toString();
    }
}
