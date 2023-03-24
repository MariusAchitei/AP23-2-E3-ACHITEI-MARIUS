package org.example.Compulsory;

public class Project implements Comparable<Project> {
    private String name;

    public Project(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int CompareTo(Project other) {
        return this.name.compareTo(other.name);
    }
}
