import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Node> nodes = new ArrayList<Node>();
        nodes.add(new Company("Google"));
        nodes.add(new Company("Microsoft"));
        nodes.add(new Company("Apple"));
        nodes.add(new Person("Andrei"));
        nodes.add(new Person("Ion"));
        nodes.add(new Person("Vasile"));
        nodes.add(new Person("Maria"));

        for (Node node : nodes) {
            System.out.println(node.getName());
        }

        nodes.sort(Node.nameComparator);
        System.out.printf("Sorted: \n");
        for (Node node : nodes) {
            System.out.println(node);
        }

    }
}