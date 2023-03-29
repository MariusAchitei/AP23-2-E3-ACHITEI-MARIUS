package Homework;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MaximumCardinality implements Problem {

    private Map<Student, List<Project>> prefMap = new HashMap<>();
    private List<Student> students = new ArrayList<>(
            IntStream.rangeClosed(0, 10)
                    .mapToObj(i -> new Student("S" + i))
                    .toList()
    );
    private List<Project> projects = new ArrayList<>(
            IntStream.rangeClosed(0, 10)
                    .mapToObj(i -> new Project("P" + i))
                    .toList()
    );
    private int noOfPreferences = 0;

    public void addStudents(List<Student> students) {
        if (students.size() == 0) return;
        for (Student student :
                students) {
            this.students.add(student);
        }
    }

//    public void addStudents(Student... students) {
//        if (students.length == 0) return;
//        for (Student student :
//                students) {
//            this.students.add(student);
//        }
//    }

    public void addProjects(Project... projects) {
//        if (projects.length == 0) return;
        for (Project project :
                projects) {
            this.projects.add(project);
        }
    }

    public void addProjects(List<Project> projects) {
//        if (projects.size() == 0) return;
        for (Project project :
                projects) {
            this.projects.add(project);
        }
    }

    public void addPreferences(Student student, List<Project> projects) {
        if (!students.contains(student))
            students.add(student);
        prefMap.put(student, projects);
        noOfPreferences += projects.size();
    }

    public void printAboveAvgStudents() {
        int average = noOfPreferences / students.size();
        students.stream()
                .filter(s -> prefMap.get(s).size() > average)
                .forEach(s -> System.out.println(s));
    }

    public void solve() {
        int[] check = new int[projects.size()];
        Map<Student, Project> matching = new HashMap();
        students.stream()
                .map(s -> {
                    int lengthMap = prefMap.get(s).size();
                    Project aux;
                    for (int i = 0; i < lengthMap; i++) {
                        aux = prefMap.get(s).get(i);
                        int index = projects.indexOf(aux);
                        if (check[index] == 0) {
                            check[index] = 1;
                            matching.put(s, aux);
                            return aux;
                        }
                    }
                    aux = prefMap.get(s).get(0);
                    matching.put(s, aux);
                    return aux;
                })
                .toList();
        for (Student student :
                students) {
            System.out.println(student.getName() + " - " + matching.get(student).getName());
        }

//        for (int i = 0; i < check.length; i++) {
//            if (check[i] == 0) {
//                for (Student s : students) {
//                    Project helper = projects.get(i);
//                    if (prefMap.get(s).contains(helper)) {
//                        System.out.println(s.getName() + " - " + helper.getName());
//                        break;
//                    }
//                }
//            }
//        }
    }


    public List<Student> getStudents() {
        return students;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public Project getRandomProject() {
        return projects.get((int) Math.random() * (projects.size() - 1));
    }
}
