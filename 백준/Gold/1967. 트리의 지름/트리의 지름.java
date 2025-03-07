import java.io.*;
import java.util.*;

class Main {
    static int n;
    static Map<Integer, List<int[]>> graph = new HashMap<>();
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(parent).add(new int[] { child, cost });
            graph.get(child).add(new int[] { parent, cost });
        }

        int farthestNode = bfs(1)[0];

        answer = bfs(farthestNode)[1];

        System.out.println(answer);
    }

    public static int[] bfs(int start) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { start, 0 });

        boolean[] visited = new boolean[n + 1];
        visited[start] = true;

        int maxDist = 0;
        int maxNode = start;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int curNode = current[0];
            int curDist = current[1];

            if (curDist > maxDist) {
                maxDist = curDist;
                maxNode = curNode;
            }

            for (int[] next : graph.get(curNode)) {
                int nextNode = next[0];
                int cost = next[1];

                if (!visited[nextNode]) {
                    queue.offer(new int[] { nextNode, cost + curDist });
                    visited[nextNode] = true;
                }
            }
        }

        return new int[] { maxNode, maxDist };
    }
}