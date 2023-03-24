import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Network implements Graph {
    public List<Node> nodes;

    public Network() {
        nodes = new LinkedList<>();
    }

    public Network(Node... nodes) {
        this.nodes = new LinkedList<>();
        if (nodes.length == 0)
            return;
        for (Node node :
                nodes) {
            this.nodes.add(node);
        }
    }

    public int isConnected(){

    }
    public List<Node> getNodes() {
        return nodes;
    }

    @Override
    public void addNodes(Node... nodes) {
        if (nodes.length == 0)
            return;
        for (Node node :
                nodes) {
            this.nodes.add(node);
        }
    }

    public void setImportance() {
        for (Node node :
                nodes) {
            node.setImportance();
        }
    }

    @Override
    public void sort() {
        nodes.sort(Node::importanceComparator);
    }
}
