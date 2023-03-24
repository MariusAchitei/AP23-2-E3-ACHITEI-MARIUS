import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Company implements Node, Comparable<Company> {
    private String name;

    private int value;
    private int importance;

    Map<Node, ConnectionType> connections;

    public Company() {
        connections = new HashMap<>();
        this.name = "Google";
    }

    public Company(String name) {
        connections = new HashMap<>();
        this.name = name;
    }

    public Company(String name, int value) {
        connections = new HashMap<>();
        this.name = name;
        this.value = value;
    }

    @Override
    public int getImportance() {
        return importance;
    }

    public void setImportance(int importance) {
        this.importance = importance;
    }

    @Override
    public void addConnection(Node toConnect, ConnectionType relation) {
        if (toConnect == this) {
            System.out.println(String.format("Conexiunea dintre %s si %s a esuat", this.getName(), toConnect.getName()));
            return;
        }
        connections.put(toConnect, relation);
    }

    @Override
    public void setImportance() {
        if (connections == null) {
            importance = 0;
            return;
        }
        importance = connections.size();
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
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
        return "Company name: " + name;
    }

    @Override
    public int compareTo(Company other) {
        return this.name.compareTo(other.name);
    }
}
