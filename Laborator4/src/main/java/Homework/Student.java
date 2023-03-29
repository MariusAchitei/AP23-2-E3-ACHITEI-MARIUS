package Homework;

import java.util.LinkedList;
import java.util.List;

public class Student {
//    static int totalPreferences = 0;
//    List<Project> preferences;
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static int studentComparator(Student s1, Student s2) {
        return s1.getName().compareTo(s2.getName());
    }
}