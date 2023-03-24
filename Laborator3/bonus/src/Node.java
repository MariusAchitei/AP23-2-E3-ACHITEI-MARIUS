public interface Node {
    String getName();

    void setImportance();

    void addConnection(Node toConnect, ConnectionType relation);

    int getImportance();

    static int nameComparator(Node o1, Node o2) {
        return o1.getName().compareTo(o2.getName());
    }

    static int importanceComparator(Node n1, Node n2) {
        if (n1.getImportance() > n2.getImportance())
            return -1;
        if (n1.getImportance() < n2.getImportance())
            return 1;
        return 0;
    }

    ;
}
