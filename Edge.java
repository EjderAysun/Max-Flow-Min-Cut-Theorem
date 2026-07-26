public class Edge {
    final private int capacity;
    final private Node from;
    final private Node to;
    private int idx;
    private int forwardVal;
    private int backwardVal;
    private boolean currentDirection; // true is forward, false is backward

    public String print() {
        return
        "capacity: " + String.valueOf(capacity) +
        ", from: " + from.getIdx() +
        ", to: " + to.getIdx() +
        ", idx: " + String.valueOf(idx) +
        ", flow: " + String.valueOf(backwardVal);
    }

    public Edge(int capacity, Node from, Node to, int idx) {
        this.capacity = capacity;
        this.from = from;
        this.to = to;
        this.idx = idx;
        this.forwardVal = capacity;
        this.backwardVal = 0;
        currentDirection = true;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getIdx() {
        return this.idx;
    }

    public void setCurrentDir(boolean dir) {
        this.currentDirection = dir;
    }

    public boolean getCurDir() {
        return this.currentDirection;
    }

    public void setFlow(int flow) {
        forwardVal -= flow;
        backwardVal += flow;
    }

    public int getForward() {
        return this.forwardVal;
    }

    public int getBackward() {
        return this.backwardVal;
    }

    public Node getFrom() {
        return this.from;
    }

    public Node getTo() {
        return this.to;
    }

    // to change the index of edge adversarily for Graph G5 example
    public void setIdx(int idx) {
        this.idx = idx;
    }
}