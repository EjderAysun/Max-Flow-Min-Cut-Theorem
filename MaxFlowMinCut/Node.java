import java.util.LinkedList;

public class Node {
    final private LinkedList<Edge> entering;
    final private LinkedList<Edge> leaving;
    final private int idx;
    private Edge prevEdge;

    public void setPrevEdge(Edge prevEdge) {
        this.prevEdge = prevEdge;
    }

    public Edge getPrevEdge() {
        return this.prevEdge;
    }

    public String print() {
        String res = "Node" + String.valueOf(idx) + " -> ";
        for (Edge e : leaving) {
            res += e.getIdx() + " -> ";
        }
        return res;
    }

    public Node(int idx) {
        entering = new LinkedList<>();
        leaving = new LinkedList<>();
        this.idx = idx;
    }

    public int getIdx() {
        return this.idx;
    }

    public void addEnteringEdge(Edge enteringEdge) {
        entering.add(enteringEdge);
    }

    public void addLeavingEdge(Edge leavingEdge) {
        leaving.add(leavingEdge);
    }

    public LinkedList<Edge> getLeaving() {
        return this.leaving;
    }

    public LinkedList<Edge> getEntering() {
        return this.entering;
    }

    // adversary injection method for only Graph G5
    public void swapPositionsByIndex(int idx1, int idx2) {
        Edge e0 = leaving.get(idx1);
        Edge e1 = leaving.get(idx2);
        e1.setIdx(idx1);
        e0.setIdx(idx2);
        leaving.set(idx1, e1);
        leaving.set(idx2, e0);
    }
}