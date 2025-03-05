import java.io.*;
import java.util.*;

class Main {
    static int[] parents;

    static class Edge {
        int v1;
        int v2;
        int cost;

        public Edge(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        List<Edge> edgeList = new ArrayList<>();

        parents = new int[v];

        for (int i = 0; i < v; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int dest = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());

            edgeList.add(new Edge(start, dest, cost));
        }

        Collections.sort(edgeList, (a, b) -> (Integer.compare(a.cost, b.cost)));

        int answer = 0;

        
        for (Edge edge : edgeList) {
            if (find(edge.v1) != find(edge.v2)) {
                union(edge.v1, edge.v2);
                answer += edge.cost;
            }
        }

        System.out.println(answer);
    }

    public static int find(int node) {
        if (parents[node] != node) {
            parents[node] = find(parents[node]);
        }
        return parents[node];
    }

    public static void union(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);

        parents[root2] = root1;
    }
}