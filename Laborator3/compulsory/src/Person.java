import java.util.Comparator;

public class Person implements Node, Comparable<Person>{
    private String name;

    public Person() {
        this.name = "Andrei";
    }
    public Person(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Person name: " + name;
    }
    @Override
    public int compareTo(Person other) {
        return this.name.compareTo(other.name);
    }

}