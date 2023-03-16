import java.util.Comparator;

public interface Node {
    String getName();
    public static Comparator<Node> nameComparator = new Comparator<Node>() {
        @Override
        public int compare(Node o1, Node o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };

}
