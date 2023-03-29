public class Student {
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