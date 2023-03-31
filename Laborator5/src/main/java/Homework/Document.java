package Homework;

import java.io.Serializable;

public class Document implements Serializable {
    private static int currentId = 0;
    private int id;
    private String name;
    private String path;

    public Document(int id, String name, String path) {
        currentId++;
        this.id = id;
        this.name = name;
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public static int getCurrentId() {
        return currentId;
    }

    public Document() {
    }

    public Document(String name, String path) {
        this.id = currentId++;
        this.name = name;
        this.path = path;
    }

    public Document(int id, String name) {
        currentId++;
        this.id = id;
        this.name = name;
    }

    public static void setCurrentId(int currentId) {
        Document.currentId = currentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Document(String name) {
        this.id = currentId++;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
