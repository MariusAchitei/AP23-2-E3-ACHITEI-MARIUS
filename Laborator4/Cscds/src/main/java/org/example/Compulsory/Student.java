package org.example.Compulsory;

public class Student implements Comparable<Student> {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int CompareTo(Student other) {
        return this.name.compareTo(other.name);
    }
}
