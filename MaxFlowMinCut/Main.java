import java.util.LinkedList;

public class Main {
        public static void main(String[] args) {
        
        System.out.println("\n------------");
        System.out.println("G1 iterations (FFA): ");
        Graph G11 = Graph1();
        MaxFlowAlgorithm.FordFulkersonMethod(G11);
        printEdgeInfo(G11);
        MaxFlowAlgorithm.FindMinCut(G11);
        System.out.println("\n------------");
        System.out.println("G1 iterations (Scaling Max-Flow Algorithm): ");
        Graph G12 = Graph1();
        MaxFlowAlgorithm.ScalingMaxFlow(G12);
        printEdgeInfo(G12);
        MaxFlowAlgorithm.FindMinCut(G12);
        System.out.println("\n------------");
        System.out.println("G1 iterations (Edmonds-Karp Algorithm): ");
        Graph G13 = Graph1();
        MaxFlowAlgorithm.EdmondsKarpAlgorithm(G13);
        printEdgeInfo(G13);
        MaxFlowAlgorithm.FindMinCut(G13);
        
        System.out.println("\n------------");
        
        System.out.println("G2 iterations (FFA): ");
        Graph G21 = Graph2();
        MaxFlowAlgorithm.FordFulkersonMethod(G21);
        printEdgeInfo(G21);
        MaxFlowAlgorithm.FindMinCut(G21);
        System.out.println("\n------------");
        System.out.println("G2 iterations (Scaling Max-Flow): ");
        Graph G22 = Graph2();
        MaxFlowAlgorithm.ScalingMaxFlow(G22);
        printEdgeInfo(G22);
        MaxFlowAlgorithm.FindMinCut(G22);
        System.out.println("\n------------");
        System.out.println("G2 iterations (Edmonds-Karp Algorithm): ");
        Graph G23 = Graph2();
        MaxFlowAlgorithm.EdmondsKarpAlgorithm(G23);
        printEdgeInfo(G23);
        MaxFlowAlgorithm.FindMinCut(G23);
        
        System.out.println("\n------------");
        
        System.out.println("G3 iterations (FFA): ");
        Graph G31 = Graph3();
        MaxFlowAlgorithm.FordFulkersonMethod(G31);
        printEdgeInfo(G31);
        MaxFlowAlgorithm.FindMinCut(G31);
        System.out.println("\n------------");
        System.out.println("G3 iterations (Scaling Max-Flow): ");
        Graph G32 = Graph3();
        MaxFlowAlgorithm.ScalingMaxFlow(G32);
        printEdgeInfo(G32);
        MaxFlowAlgorithm.FindMinCut(G32);
        System.out.println("\n------------");
        System.out.println("G3 iterations (Edmonds-Karp Algorithm): ");
        Graph G33 = Graph3();
        MaxFlowAlgorithm.EdmondsKarpAlgorithm(G33);
        printEdgeInfo(G33);
        MaxFlowAlgorithm.FindMinCut(G33);
                
        System.out.println("\n------------");
        
        System.out.println("G4 iterations (FFA): ");
        Graph G41 = Graph4();
        MaxFlowAlgorithm.FordFulkersonMethod(G41);
        printEdgeInfo(G41);
        MaxFlowAlgorithm.FindMinCut(G41);
        System.out.println("\n------------");
        System.out.println("G4 iterations (Scaling Max-Flow): ");
        Graph G42 = Graph4();
        MaxFlowAlgorithm.ScalingMaxFlow(G42);
        printEdgeInfo(G42);
        MaxFlowAlgorithm.FindMinCut(G42);
        System.out.println("\n------------");
        System.out.println("G4 iterations (Edmonds-Karp Algorithm): ");
        Graph G43 = Graph4();
        MaxFlowAlgorithm.EdmondsKarpAlgorithm(G43);
        printEdgeInfo(G43);
        MaxFlowAlgorithm.FindMinCut(G43);

        // System.out.println("G5 iterations (FFA): ");
        // Graph G51 = Graph5();
        // MaxFlowAlgorithm.FordFulkersonMethod(G51);
        // printEdgeInfo(G51);
        // MaxFlowAlgorithm.FindMinCut(G51);
        // System.out.println("\n------------");
        // System.out.println("G5 iterations (Scaling Max-Flow): ");
        // Graph G52 = Graph5();
        // MaxFlowAlgorithm.ScalingMaxFlow(G52);
        // printEdgeInfo(G52);
        // MaxFlowAlgorithm.FindMinCut(G52);
        // System.out.println("\n------------");
        // System.out.println("G5 iterations (Edmonds-Karp Algorithm): ");
        // Graph G53 = Graph5();
        // MaxFlowAlgorithm.EdmondsKarpAlgorithm(G53);
        // printEdgeInfo(G53);
        // MaxFlowAlgorithm.FindMinCut(G53);
    }

    public static void printEdgeInfo(Graph G) {
        LinkedList<Edge> edges = G.getEdges();
        System.out.println("Flows:");
        for(Edge e : edges) {
            System.out.println(e.print());
        }
    }

    public static Graph Graph1() {
        // Example graph from Algorithm Design Book, pg. 341, Figure 7.3
        Node n0 = new Node(0); // s
        Node n1 = new Node(1); // u
        Node n2 = new Node(2); // v
        Node n3 = new Node(3); // t

        Edge e0 = new Edge(20, n0, n1, 0);
        Edge e1 = new Edge(10, n0, n2, 1);
        Edge e2 = new Edge(30, n1, n2, 2);
        Edge e3 = new Edge(10, n1, n3, 3);
        Edge e4 = new Edge(20, n2, n3, 4);

        n0.addLeavingEdge(e0);
        n0.addLeavingEdge(e1);
        n1.addEnteringEdge(e0);
        n1.addLeavingEdge(e2);
        n1.addLeavingEdge(e3);
        n2.addEnteringEdge(e1);
        n2.addEnteringEdge(e2);
        n2.addLeavingEdge(e4);
        n3.addEnteringEdge(e3);
        n3.addEnteringEdge(e4);

        Graph G = new Graph();

        G.setNode(n0);
        G.setNode(n1);
        G.setNode(n2);
        G.setNode(n3);

        G.setEdge(e0);
        G.setEdge(e1);
        G.setEdge(e2);
        G.setEdge(e3);
        G.setEdge(e4);

        return G;
    }

    public static Graph Graph2() {
        Node n0 = new Node(0);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        Edge e0 = new Edge(150, n0, n1, 0);
        Edge e1 = new Edge(30, n0, n2, 1);
        Edge e2 = new Edge(90, n1, n3, 2);
        Edge e3 = new Edge(30, n1, n4, 3);
        Edge e4 = new Edge(150, n3, n2, 4);
        Edge e5 = new Edge(40, n2, n4, 5);
        Edge e6 = new Edge(60, n3, n5, 6);
        Edge e7 = new Edge(100, n4, n5, 7);

        n0.addLeavingEdge(e0);
        n0.addLeavingEdge(e1);
        n1.addEnteringEdge(e0);
        n1.addLeavingEdge(e2);
        n1.addLeavingEdge(e3);
        n2.addEnteringEdge(e1);
        n2.addEnteringEdge(e4);
        n2.addLeavingEdge(e5);
        n3.addEnteringEdge(e2);
        n3.addLeavingEdge(e4);
        n3.addLeavingEdge(e6);
        n3.addEnteringEdge(e2);
        n4.addLeavingEdge(e7);
        n4.addEnteringEdge(e3);
        n4.addEnteringEdge(e5);
        n5.addEnteringEdge(e6);
        n5.addEnteringEdge(e7);

        Graph G = new Graph();

        G.setNode(n0);
        G.setNode(n1);
        G.setNode(n2);
        G.setNode(n3);
        G.setNode(n4);
        G.setNode(n5);

        G.setEdge(e0);
        G.setEdge(e1);
        G.setEdge(e2);
        G.setEdge(e3);
        G.setEdge(e4);
        G.setEdge(e5);
        G.setEdge(e6);
        G.setEdge(e7);

        return G;
    }

    public static Graph Graph3() {
        // a simple graph to test scaling max flow algorithm
        Node n0 = new Node(0); // s
        Node n1 = new Node(1); // u
        Node n2 = new Node(2); // v
        Node n3 = new Node(3); // t

        Edge e0 = new Edge(10, n0, n1, 0);
        Edge e1 = new Edge(100, n0, n2, 1);
        Edge e2 = new Edge(70, n1, n3, 2);
        Edge e3 = new Edge(20, n2, n3, 3);
        Edge e4 = new Edge(90, n2, n1, 4);

        n0.addLeavingEdge(e0);
        n0.addLeavingEdge(e1);
        n1.addEnteringEdge(e0);
        n1.addEnteringEdge(e4);
        n1.addLeavingEdge(e2);
        n2.addEnteringEdge(e1);
        n2.addLeavingEdge(e3);
        n2.addLeavingEdge(e4);
        n3.addEnteringEdge(e2);
        n3.addEnteringEdge(e3);

        Graph G = new Graph();

        G.setNode(n0);
        G.setNode(n1);
        G.setNode(n2);
        G.setNode(n3);

        G.setEdge(e0);
        G.setEdge(e1);
        G.setEdge(e2);
        G.setEdge(e3);
        G.setEdge(e4);

        return G;
    }

    // Graph from: https://upload.wikimedia.org/wikipedia/commons/thumb/2/2f/Pets_flow.svg/960px-Pets_flow.svg.png
    public static Graph Graph4() {
        Node n0 = new Node(0);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);
        Node n10 = new Node(10);
        Node n11 = new Node(11);
        Node n12 = new Node(12);
        Node n13 = new Node(13);
        Node n14 = new Node(14);

        Edge e0 = new Edge(1, n0, n1, 0);
        Edge e1 = new Edge(1,n0,n2, 1);
        Edge e2 = new Edge(1,n0,n3, 2);
        Edge e3 = new Edge(1,n0,n4, 3);
        Edge e4 = new Edge(1,n0,n5, 4);
        Edge e5 = new Edge(1,n1,n6, 5);
        Edge e6 = new Edge(1,n1,n8, 6);
        Edge e7 = new Edge(1,n2,n6, 7);
        Edge e8 = new Edge(1,n2,n9, 8);
        Edge e9 = new Edge(1,n3,n8, 9);
        Edge e10 = new Edge(1,n4,n10, 10);
        Edge e11 = new Edge(1,n5,n7, 11);
        Edge e12 = new Edge(1,n5,n10, 12);
        Edge e13 = new Edge(1,n6,n11, 13);
        Edge e14 = new Edge(1,n7,n11, 14);
        Edge e15 = new Edge(1,n8,n12, 15);
        Edge e16 = new Edge(1,n9,n13, 16);
        Edge e17 = new Edge(1,n10,n13, 17);
        Edge e18 = new Edge(3,n11,n14, 18);
        Edge e19 = new Edge(3,n12,n14, 19);
        Edge e20 = new Edge(3,n13,n14, 20);

        n1.addEnteringEdge(e0);
        n2.addEnteringEdge(e1);
        n3.addEnteringEdge(e2);
        n4.addEnteringEdge(e3);
        n5.addEnteringEdge(e4);
        n6.addEnteringEdge(e5);
        n6.addEnteringEdge(e7);
        n7.addEnteringEdge(e11);
        n8.addEnteringEdge(e6);
        n8.addEnteringEdge(e9);
        n9.addEnteringEdge(e8);
        n10.addEnteringEdge(e10);
        n10.addEnteringEdge(e12);
        n11.addEnteringEdge(e13);
        n11.addEnteringEdge(e14);
        n12.addEnteringEdge(e15);
        n13.addEnteringEdge(e16);
        n13.addEnteringEdge(e17);
        n14.addEnteringEdge(e18);
        n14.addEnteringEdge(e19);
        n14.addEnteringEdge(e20);
        
        n0.addLeavingEdge(e0);
        n0.addLeavingEdge(e1);
        n0.addLeavingEdge(e2);
        n0.addLeavingEdge(e3);
        n0.addLeavingEdge(e4);
        n1.addLeavingEdge(e5);
        n1.addLeavingEdge(e6);
        n2.addLeavingEdge(e7);
        n2.addLeavingEdge(e8);
        n3.addLeavingEdge(e9);
        n4.addLeavingEdge(e10);
        n5.addLeavingEdge(e11);
        n5.addLeavingEdge(e12);
        n6.addLeavingEdge(e13);
        n7.addLeavingEdge(e14);
        n8.addLeavingEdge(e15);
        n9.addLeavingEdge(e16);
        n10.addLeavingEdge(e17);
        n11.addLeavingEdge(e18);
        n12.addLeavingEdge(e19);
        n13.addLeavingEdge(e20);

        Graph G = new Graph();
        G.setNode(n0);
        G.setNode(n1);
        G.setNode(n2);
        G.setNode(n3);
        G.setNode(n4);
        G.setNode(n5);
        G.setNode(n6);
        G.setNode(n7);
        G.setNode(n8);
        G.setNode(n9);
        G.setNode(n10);
        G.setNode(n11);
        G.setNode(n12);
        G.setNode(n13);
        G.setNode(n14);

        G.setEdge(e0);
        G.setEdge(e1);
        G.setEdge(e2);
        G.setEdge(e3);
        G.setEdge(e4);
        G.setEdge(e5);
        G.setEdge(e6);
        G.setEdge(e7);
        G.setEdge(e8);
        G.setEdge(e9);
        G.setEdge(e10);
        G.setEdge(e11);
        G.setEdge(e12);
        G.setEdge(e13);
        G.setEdge(e14);
        G.setEdge(e15);
        G.setEdge(e16);
        G.setEdge(e17);
        G.setEdge(e18);
        G.setEdge(e19);
        G.setEdge(e20);

        return G;
    }

    // Good graph example to see pathological path choices
    public static Graph Graph5() {
        // 
        Node n0 = new Node(0); // s
        Node n1 = new Node(1); // u
        Node n2 = new Node(2); // v
        Node n3 = new Node(3); // t

        Edge e0 = new Edge(100, n0, n2, 0);
        Edge e1 = new Edge(100, n0, n1, 1);
        Edge e2 = new Edge(100, n1, n3, 2);
        Edge e3 = new Edge(100, n2, n3, 3);
        Edge e4 = new Edge(1, n2, n1, 4);

        /*
            2
        e0/ |  \e3
         /  |   \
        0   |e4  3
         \  |   /
        e1\ |. /e2
            1
        */

        n0.addLeavingEdge(e0);
        n0.addLeavingEdge(e1);
        n1.addEnteringEdge(e1);
        n1.addEnteringEdge(e4);
        n1.addLeavingEdge(e2);
        n2.addEnteringEdge(e0);
        n2.addLeavingEdge(e3);
        n2.addLeavingEdge(e4);
        n3.addEnteringEdge(e2);
        n3.addEnteringEdge(e3);

        Graph G = new Graph();

        G.setNode(n0);
        G.setNode(n1);
        G.setNode(n2);
        G.setNode(n3);

        G.setEdge(e0);
        G.setEdge(e1);
        G.setEdge(e2);
        G.setEdge(e3);
        G.setEdge(e4);

        return G;
    }

}