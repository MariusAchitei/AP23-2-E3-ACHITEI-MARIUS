import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        List<Node> nodes = new ArrayList<>();
        nodes.add(new Company("Google"));
        nodes.add(new Company("Microsoft"));
        nodes.add(new Company("Apple"));
        nodes.add(new Person("Andrei"));
        nodes.add(new Person("Vasile"));
        nodes.add(new Person("Ion"));
        nodes.add(new Person("Maria"));

//        for (Node node : nodes) {
//            System.out.println(node.getName());
//        }
//
//        nodes.sort(Node::nameComparator);
//        System.out.printf("Sorted: \n");
//        for (Node node : nodes) {
//            System.out.println(node);
//        }
        Node p1 = new Programmer("Gianny", "SQL", "JAVA");
        Node p2 = new Programmer("Mihai", "C");
        Node d1 = new Designer("Archibald", 100);
        Node d2 = new Designer("Ion", 10);
        Node c1 = new Company("Google", 999999);
        Node c2 = new Company("bOMBEU", 2);

        p1.addConnection(p2, ConnectionType.BAD);
        p2.addConnection(p1, ConnectionType.GOOD);
        p1.addConnection(d1, ConnectionType.REGULAR);
        p1.addConnection(d2, ConnectionType.BAD);
        p2.addConnection(c1, ConnectionType.GOOD);
        d1.addConnection(d2, ConnectionType.GOOD);
        c2.addConnection(p1, ConnectionType.GOOD);
        c2.addConnection(p2, ConnectionType.REGULAR);
        c2.addConnection(d1, ConnectionType.BAD);
        c2.addConnection(d2, ConnectionType.GOOD);

        Graph network = new Network(p1, p2, d1, d2);
        network.addNodes(c1, c2);
        network.setImportance();
        network.sort();

        for (Node node :
                network.getNodes()) {
            System.out.println(node + " importance: " + node.getImportance());
        }

    }
}