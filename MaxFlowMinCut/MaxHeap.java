
public class MaxHeap {
    final private int[] heapTree;
    final private Node[] nodes;
    final private int[] pos;

    private int size = 0;

    public int getSize() {
        return this.size;
    }

    public int getMax() {
        return this.heapTree[0];
    }

    public int getPos(Node n) {
        return pos[n.getIdx()];
    }

    public int getCapacity(Node n) {
        return heapTree[pos[n.getIdx()]];
    }

    public MaxHeap(int numOfNodes) {
        heapTree = new int[numOfNodes];
        nodes = new Node[numOfNodes];
        pos = new int[numOfNodes];
        for(int i = 0; i < numOfNodes; i++) {
            pos[i] = -1;
        }
    }

    public void insert(Node n, int val) {
        heapTree[size] = val;
        nodes[size] = n;
        pos[n.getIdx()] = size;
        heapifyUp(size, val, n); // as an index
        size++;
    }

    public void replace(int newVal, Node n) {
        int idx = n.getIdx();
        heapTree[pos[idx]] = newVal;
        heapifyUp(pos[idx], newVal, n);
    }

    private void swap(int parentIdx, int idx, int val, Node n) {
        int tempParentVal = heapTree[parentIdx];
        Node tempParentNode = nodes[parentIdx];
        heapTree[parentIdx] = val;
        nodes[parentIdx] = n;
        pos[n.getIdx()] = parentIdx;
        heapTree[idx] = tempParentVal;
        nodes[idx] = tempParentNode;
        pos[tempParentNode.getIdx()] = idx;
    }

    public void heapifyUp(int idx, int val, Node n) {
        int parentIdx = (int)Math.ceil(idx / 2.0) - 1;
        while(parentIdx >= 0) {
            if(heapTree[parentIdx] < val) {
                swap(parentIdx, idx, val, n);
                idx = parentIdx;
                parentIdx = (int)Math.ceil(parentIdx / 2.0) - 1;
            } else break;
        }
    }

    public void heapifyDown(int idx, int val, Node n) {
        int leftChildIndex = 2*idx + 1;
        int rightChildIndex = 2*idx + 2;

        while (true) {
            if(rightChildIndex <= size-1) {
                if(heapTree[idx] < heapTree[leftChildIndex] ||
                    heapTree[idx] < heapTree[rightChildIndex]) {
                    if(heapTree[leftChildIndex] > heapTree[rightChildIndex]) {
                        swap(leftChildIndex, idx, val, n);
                        idx = leftChildIndex;
                    } else {
                        swap(rightChildIndex, idx, val, n);
                        idx = rightChildIndex;
                    }
                    leftChildIndex = 2*idx + 1;
                    rightChildIndex = 2*idx + 2;
                } else break;
            } else if (leftChildIndex <= size - 1) {
                if(heapTree[idx] < heapTree[leftChildIndex]) {
                    swap(leftChildIndex, idx, val, n);
                } else break;
            } else {
                break;
            }
        }
    }

    public Node extractMax() {
        Node maxNode = nodes[0];
        pos[maxNode.getIdx()] = -2;
        size--;
        if (size > 0) {
            int e = heapTree[size];
            Node n = nodes[size];
            heapTree[0] = e;
            nodes[0] = n;
            pos[n.getIdx()] = 0;
            heapifyDown(0, e, n);
        }
        return maxNode;
    }

}