import java.util.LinkedList;

public class Graph {
    final private LinkedList<Node> nodes;
    final private LinkedList<Edge> edges;

    public Node getSource() {
        return nodes.getFirst();
    }

    public Graph() {
        nodes = new LinkedList<>();
        edges = new LinkedList<>();
    }

    public void setNode(Node node) {
        nodes.add(node);
    }

    public void setEdge(Edge edge) {
        edges.add(edge);
    }

    public LinkedList<Node> getNodes() {
        return nodes;
    }

    public LinkedList<Edge> getEdges() {
        return edges;
    }
}