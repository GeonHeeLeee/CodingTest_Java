import java.io.*;
import java.util.*;

class Main {
    static int n, m;
    static int[][] locations;
    static List<Edge> edgeList = new ArrayList<>();
    static int[] parent;

    static class Edge {
        int nodeA;
        int nodeB;
        double dist;

        public Edge(double dist) {
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];
        locations = new int[n + 1][2];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            locations[i][0] = Integer.parseInt(st.nextToken());
            locations[i][1] = Integer.parseInt(st.nextToken());
            parent[i] = i;
        }

        boolean[][] isConnected = new boolean[n + 1][n + 1];
        List<Edge> alreadyConnected = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());
            Edge edge = new Edge(
                    calculateDist(locations[nodeA][0], locations[nodeA][1], locations[nodeB][0], locations[nodeB][1]));
            edge.nodeA = nodeA;
            edge.nodeB = nodeB;
            isConnected[nodeA][nodeB] = true;
            isConnected[nodeB][nodeA] = true;
            alreadyConnected.add(edge);
        }

        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= n; c++) {
                if (!isConnected[r][c]) {
                    int nodeA = r;
                    int nodeB = c;
                    Edge edge = new Edge(
                            calculateDist(locations[nodeA][0], locations[nodeA][1], locations[nodeB][0],
                                    locations[nodeB][1]));
                    edge.nodeA = nodeA;
                    edge.nodeB = nodeB;
                    edgeList.add(edge);
                    isConnected[nodeA][nodeB] = true;
                    isConnected[nodeB][nodeA] = true;
                }
            }
        }

        double answer = 0;

        for (int i = 0; i < alreadyConnected.size(); i++) {
            Edge edge = alreadyConnected.get(i);
            if (find(edge.nodeA) != find(edge.nodeB)) {
                union(edge.nodeA, edge.nodeB);
            }
        }

        Collections.sort(edgeList, (a, b) -> Double.compare(a.dist, b.dist));
        for (int i = 0; i < edgeList.size(); i++) {
            Edge edge = edgeList.get(i);
            if (find(edge.nodeA) != find(edge.nodeB)) {
                union(edge.nodeA, edge.nodeB);
                answer += edge.dist;
            }
        }
        System.out.println(String.format("%.2f", answer));
    }

    public static int find(int node) {
        if (parent[node] != node) {
            parent[node] = find(parent[node]);
        }
        return parent[node];
    }

    public static void union(int nodeA, int nodeB) {
        int rootA = find(nodeA);
        int rootB = find(nodeB);

        parent[rootB] = rootA;
    }

    public static double calculateDist(int rowA, int colA, int rowB, int colB) {
        return Math.sqrt(Math.pow(rowA - rowB, 2) + Math.pow(colA - colB, 2));
    }

}