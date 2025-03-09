import java.io.*;
import java.util.*;

class Main {
    static int n, e, v1, v2;
    static Map<Integer, List<int[]>> graph = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        for (int node = 1; node <= n; node++) {
            graph.put(node, new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(start).add(new int[] { dest, cost });
            graph.get(dest).add(new int[] { start, cost });
        }

        st = new StringTokenizer(br.readLine());

        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        int[][] ways = new int[][] { { 1, v1, v2, n }, { 1, v2, v1, n } };
        int answer = Integer.MAX_VALUE;
        // start - v1 - v2 - dest

        for (int[] way : ways) {
            int sum = 0;
            for (int idx = 0; idx < way.length - 1; idx++) {
                int result = bfs(way[idx], way[idx + 1]);
                if (result == -1) {
                    sum = -1;
                    break;
                }
                sum += result;
            }
            if (sum != -1) {
                answer = Math.min(answer, sum);
            }

        }
        if (answer == Integer.MAX_VALUE) {
            answer = -1;
        }
        System.out.println(answer);

    }

    public static int bfs(int start, int dest) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        queue.offer(new int[] { start, 0 });
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int curNode = current[0];
            int curCost = current[1];

            for (int[] next : graph.get(curNode)) {
                int nextNode = next[0];
                int nextCost = next[1];

                if (curCost + nextCost < dist[nextNode]) {
                    queue.offer(new int[] { nextNode, curCost + nextCost });
                    dist[nextNode] = curCost + nextCost;
                }
            }
        }
        return dist[dest] == Integer.MAX_VALUE ? -1 : dist[dest];
    }
}