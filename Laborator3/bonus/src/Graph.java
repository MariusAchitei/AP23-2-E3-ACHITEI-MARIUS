import java.util.List;

public interface Graph {
    public void addNodes(Node... nodes);

    public void setImportance();

    public List<Node> getNodes();

    void sort();
}
