package Homework;

public class Project implements Comparable<Project> {
    private String name;

    public Project(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int nameComparator(Project p1, Project p2) {
        return p1.getName().compareTo(p2.getName());
    }

    @Override
    public int compareTo(Project other) {
        return this.getName().compareTo(other.getName());
    }
}
