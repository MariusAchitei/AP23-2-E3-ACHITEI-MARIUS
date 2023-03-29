package Homework;

import java.util.List;

public interface Problem {
//    void addStudents(Student... students);

    void addStudents(List<Student> students);

//    void addProjects(Project... projects);

    void addProjects(List<Project> projects);

    void addPreferences(Student student, List<Project> projects);

    List<Student> getStudents();

    Project getRandomProject();
    void solve();
}
