package Homework;

import java.util.*;
import java.util.stream.IntStream;

import com.github.javafaker.Faker;

public class Main {
    public static void main(String[] args) {
        Faker faker = new Faker();
        Random rand = new Random();

        MaximumCardinality problem = new MaximumCardinality();

        problem.addStudents(
                IntStream.rangeClosed(0, 10)
                        .mapToObj(i -> new Student(faker.name().fullName()))
                        .toList()
        );

        problem.addProjects(
                IntStream.rangeClosed(0, 10)
                        .mapToObj(i -> new Project("P" + i))
                        .toList()
        );

        for (Student student :
                problem.students) {
            LinkedList<Project> projectLinkedList=new LinkedList<>();
            for (int i = 0; i < (int) Math.random() * 4 + 1; i++){
                projectLinkedList.add(problem.getRandomProject());
            }
                problem.addPreferences(student, projectLinkedList);
        }
        problem.printAboveAvgStudents();
        problem.solve();
    }
}
