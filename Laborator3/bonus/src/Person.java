import javax.management.relation.RelationType;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Person implements Node, Comparable<Person> {
    private String name;
    private Date birthDate;
    private int importance;

    @Override
    public int getImportance() {
        return importance;
    }

    public void setImportance(int importance) {
        if (connections == null) {
            importance = 0;
            return;
        }
        this.importance = importance;
    }

    Map<Node, ConnectionType> connections;

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Person() {
        connections = new HashMap<>();
        this.name = "Andrei";
    }

    public Person(String name) {
        connections = new HashMap<>();
        this.name = name;
    }

    @Override
    public void addConnection(Node toConnect, ConnectionType relation) {
        if (toConnect == this)
            return;
        connections.put(toConnect, relation);
    }

    @Override
    public void setImportance() {
        importance = connections.size();
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