import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            Map<Integer, List<Integer>> graph = new HashMap<>();

            for (int node = 1; node <= v; node++) {
                graph.put(node, new ArrayList<>());
            }

            for (int j = 0; j < e; j++) {
                st = new StringTokenizer(br.readLine());

                int node1 = Integer.parseInt(st.nextToken());
                int node2 = Integer.parseInt(st.nextToken());

                graph.get(node1).add(node2);
                graph.get(node2).add(node1);
            }

            boolean result = bfs(graph, v);

            if (result) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static boolean bfs(Map<Integer, List<Integer>> graph, int v) {
        int[] colors = new int[v + 1];

        for (int start = 1; start <= v; start++) {
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(start);
            colors[start] = start;

            while (!queue.isEmpty()) {
                int curNode = queue.poll();

                for (int next : graph.get(curNode)) {
                    if (colors[next] == 0) {
                        colors[next] = colors[curNode] * -1;
                        queue.offer(next);
                    } else if (colors[next] == colors[curNode]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}