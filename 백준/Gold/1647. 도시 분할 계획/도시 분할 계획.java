import java.io.*;
import java.util.*;

class Main {
    static int n, m;
    static int[] parent;
    static List<int[]> edgeList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edgeList.add(new int[] { start, end, cost });
        }

        Collections.sort(edgeList, (a, b) -> Integer.compare(a[2], b[2]));
        int maxEdge = Integer.MIN_VALUE;
        int minSpanning = 0;

        for (int[] edge : edgeList) {
            int start = edge[0];
            int end = edge[1];
            int cost = edge[2];

            if (find(start) != find(end)) {
                union(start, end);
                minSpanning += cost;
                maxEdge = cost;
            }
        }

        System.out.println(minSpanning - maxEdge);

    }

    public static int find(int node) {
        if (node != parent[node]) {
            parent[node] = find(parent[node]);
        }
        return parent[node];
    }

    public static void union(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);

        parent[root2] = root1;
    }
}