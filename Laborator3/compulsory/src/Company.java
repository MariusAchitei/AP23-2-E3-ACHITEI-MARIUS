import java.util.Comparator;

public class Company implements Node, Comparable<Company>{
    private String name;

    public Company() {
        this.name = "Google";
    }
    public Company(String name) {
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
        return "Company name: " + name;
    }
    @Override
    public int compareTo(Company other) {
        return this.name.compareTo(other.name);
    }
}
