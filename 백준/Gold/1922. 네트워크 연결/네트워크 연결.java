import java.io.*;
import java.util.*;

class Main {
    static int n, m;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        parent = new int[n + 1];

        for (int node = 1; node <= n; node++) {
            parent[node] = node;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[2] - b[2]));
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            pq.add(new int[] { node1, node2, cost });
        }

        int answer = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node1 = current[0];
            int node2 = current[1];
            int cost = current[2];

            if (find(node1) != find(node2)) {
                union(node1, node2);
                answer += cost;
            }
        }

        System.out.println(answer);

    }

    public static int find(int node) {
        if (parent[node] != node) {
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