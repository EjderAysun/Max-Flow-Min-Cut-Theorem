import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MaxFlowAlgorithm {

    // common helper function
    public static int bottleneck(Graph G) {
        Node v = G.getNodes().getLast();
        Node s = G.getNodes().getFirst();
        Edge e = v.getPrevEdge();
        int bottleneck_val = e.getForward();
        v = e.getFrom();
        int candidate_bottleneck;

        while(v != s) {
            e = v.getPrevEdge();
            if(e.getCurDir()) {
                candidate_bottleneck = e.getForward();
                v = e.getFrom();
            } else {
                candidate_bottleneck = e.getBackward();
                v = e.getTo();
            }
            if (candidate_bottleneck < bottleneck_val) {
                bottleneck_val = candidate_bottleneck;
            }
        }
        return bottleneck_val;
    }

    // common helper function
    public static void augment(Graph G) {
        Node v = G.getNodes().getLast();
        Node s = G.getNodes().getFirst();

        int b = bottleneck(G);
        Edge e;

        while(v != s) {
            e = v.getPrevEdge();
            if(e.getCurDir() == true) {
                e.setFlow(b);
                v = e.getFrom();
            } else {
                e.setFlow(-b);
                v = e.getTo();
            }
        }
    }

    // common helper function
    public static void FindMinCut(Graph G) {
        ArrayList<Node> A = new ArrayList<>();
        ArrayList<Node> B = new ArrayList<>();
        ArrayList<Edge> cutEdges = new ArrayList<>();

        LinkedList<Node> nodes = G.getNodes();

        boolean visited[] = new boolean[nodes.size()];
        visited[0] = true;
        Queue<Node> q = new LinkedList<>();
        q.add(nodes.getFirst());

        while(!q.isEmpty()) {
            Node n = q.poll();
            A.add(n);

            for(Edge edge : n.getLeaving()) {
                if (edge.getForward() > 0 && !visited[edge.getTo().getIdx()]) {
                    visited[edge.getTo().getIdx()] = true;
                    q.add(edge.getTo());
                }
            }
            for(Edge edge : n.getEntering()) {
                if (edge.getBackward() > 0 && !visited[edge.getFrom().getIdx()]) {
                    visited[edge.getFrom().getIdx()] = true;
                    q.add(edge.getFrom());
                }
            }
        }

        for(int i = 0; i < visited.length; i++) {
            if(!visited[i]) B.add(nodes.get(i));
        }

        for(Node a : A) {
            for(Edge e : a.getLeaving()) {
                if(visited[e.getFrom().getIdx()] ^ visited[e.getTo().getIdx()]) {
                    cutEdges.add(e);
                }
            }
            for(Edge e : a.getEntering()) {
                if(visited[e.getFrom().getIdx()] ^ visited[e.getTo().getIdx()]) {
                    cutEdges.add(e);
                }
            }
        }

        System.out.print("A: ");
        for(Node a : A) {
            System.out.print(a.getIdx() + " ");
        }
        System.out.print("\nB: ");
        for(Node b : B) {
            System.out.print(b.getIdx() + " ");
        }
        System.out.print("\nCut Edges: ");
        for(Edge cut : cutEdges) {
            System.out.print(cut.getIdx() + " ");
        }
    }

    // common helper function
    public static boolean BFS(Graph G, int delta) {
        LinkedList<Node> nodes = G.getNodes();
        
        boolean[] visited = new boolean[nodes.size()];
        visited[0] = true;
        for(int i = 1; i < nodes.size(); i++) {
            visited[i] = false;
        }

        Queue<Node> q = new LinkedList<>();
        Node s = nodes.get(0); // s is source
        q.add(s);

        while(!q.isEmpty()) {

            Node v = q.poll();

            if (v == nodes.getLast()) {
                System.out.println("--------------");
                System.out.println("path is found");
                return true;
            }

            for(Edge e : v.getLeaving()) {
                int idx = e.getTo().getIdx();
                if (e.getForward() >= delta && !visited[idx]) {
                    visited[idx] = true;
                    e.setCurrentDir(true);
                    e.getTo().setPrevEdge(e);
                    q.add(e.getTo());                    
                }
            }

            for(Edge e : v.getEntering()) {
                int idx = e.getFrom().getIdx();
                if(e.getBackward() >= delta && !visited[idx]) {
                    visited[idx] = true;
                    e.setCurrentDir(false);
                    e.getFrom().setPrevEdge(e);
                    q.add(e.getFrom());
                }
            }

        }
        return false;
    }

    // DFS with adversary injection
    // (swap index-0-edge and index-1-edge leaving from s for each DFS execution)\
    // This is especially necessary for Graph G5 example to understand pathological path choices
    public static boolean DFS(Graph G, int delta) {
        LinkedList<Node> nodes = G.getNodes();

        boolean[] visited = new boolean[nodes.size()];
        visited[0] = true;
        for(int i = 1; i < nodes.size(); i++) {
            visited[i] = false;
        }

        Stack<Node> q = new Stack<>();
        Node s = nodes.get(0); // s is source
        
        // adversary injection for Graph G5 example
        // but it will run correctly if there are at least two edges leaving from s
        // if you do not want to use this then simply comment directly
        s.swapPositionsByIndex(0, 1);
        
        q.add(s);

        while(!q.isEmpty()) {

            Node v = q.pop();

            visited[v.getIdx()]= true;
            if (v == nodes.getLast()) {
                System.out.println("--------------");
                System.out.println("path is found");
                return true;
            }

            for(Edge e : v.getLeaving()) {
                int idx = e.getTo().getIdx();
                if (e.getForward() >= delta && !visited[idx]) {
                    e.setCurrentDir(true);
                    e.getTo().setPrevEdge(e);
                    q.add(e.getTo());                    
                }
            }

            for(Edge e : v.getEntering()) {
                int idx = e.getFrom().getIdx();
                if(e.getBackward() >= delta && !visited[idx]) {
                    e.setCurrentDir(false);
                    e.getFrom().setPrevEdge(e);
                    q.add(e.getFrom());
                }
            }

        }
        return false;
    }

    // common helper function
    public static void PrintAllFlows(Graph G) {
        LinkedList<Edge> edges = G.getEdges();
        // Only for information
        System.out.println("Flows at the end of the iteration: ");
        for(Edge edge : edges) {
            System.out.println(edge.print());
        }
    }

    // FORD FULKERSON METHOD
    // pseudo polynomial with DFS: O(|E|.C)
    // C is the max capacity (sum of capacity of all edges leaving from source(s))
    public static void FordFulkersonMethod(Graph G) {
        while(true) {
            // We can also use BFS to find an s-t path
            // but it's special name is Edmonds-Karp Algorithm.
            if(DFS(G, 1)) {
                augment(G);
                PrintAllFlows(G);
            }
            else break;
        }
    }
    
    // strongly polynomial Edmonds-Karp Algorithm: O(|V|.(|E|^2))
    public static void EdmondsKarpAlgorithm(Graph G) {
        while(true) {
            // find shortest path from s to t without using any edge capacity
            // (there is no C term in the complexity, that's good)
            if(BFS(G, 1)) {
                augment(G);
                PrintAllFlows(G);
            }
            else break;
        }
    }
    
    // helper function for Scaling Max-Flow Algorithm
    public static int defineDelta(Graph G) {
        Node s = G.getSource();
        int C = 0;
        for (Edge e : s.getLeaving()) {
            C += e.getCapacity();
        }
        // return (int)Math.pow(2, Math.floor(Math.log10(C)/Math.log10(2)));
        // improvement:
        return Integer.highestOneBit(C);
    }
    
    // SCALING MAX-FLOW ALGORITHM
    // Complexity: O((|E|^2).log_2(C))
    // C is the max capacity (sum of capacity of all edges leaving from source(s))
    public static void ScalingMaxFlow(Graph G) {
        
        int delta = defineDelta(G);
        while(delta >= 1) {
            while(true) {
                if(DFS(G, delta)) {
                    augment(G);
                    PrintAllFlows(G);
                }
                else break;
            }
            System.out.println("Current delta:" + delta);
            delta /= 2;
        }
    }
    
}