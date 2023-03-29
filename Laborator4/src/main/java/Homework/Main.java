package Homework;

import java.util.*;
import java.util.stream.IntStream;

import com.github.javafaker.Faker;

public class Main {
    public static void main(String[] args) {
        Faker faker = new Faker();
        Random rand = new Random();

        Problem problem = new MaximumCardinality();

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
                problem.getStudents()) {
            for (int i = 0; i < (int) Math.random() * 4; i++)
                problem.addPreferences(student, Arrays.asList(problem.getRandomProject()));
        }

    }
}
