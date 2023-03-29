import com.sun.source.tree.Tree;

import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new LinkedList<>(
                IntStream.rangeClosed(0, 3)
                        .mapToObj(i -> new Student("S" +i))
                        .toList()
        );
        TreeSet<Project> projects = new TreeSet<Project>(
                IntStream.rangeClosed(0, 3)
                        .mapToObj(i -> new Project("P" + i))
                        .toList()
        );

        students.sort(Student::studentComparator);
        students.forEach(i -> System.out.println(i.getName()));

        for (var project : projects) {
            System.out.print(project.getName());
            System.out.println();
        }

    }
}
