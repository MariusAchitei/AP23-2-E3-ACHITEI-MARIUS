package Compulsory;

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

    public Catalog(String name) {
        documents = new LinkedList<>();
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
