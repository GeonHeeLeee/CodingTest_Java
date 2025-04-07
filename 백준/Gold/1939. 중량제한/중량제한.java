import java.io.*;
import java.util.*;

class Main {
    static int n, m, start, dest;
    static Map<Integer, List<long[]>> graph = new HashMap<>();
    static long maxWeight = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long weight = Integer.parseInt(st.nextToken());

            graph.get(a).add(new long[] { b, weight });
            graph.get(b).add(new long[] { a, weight });

            maxWeight = Math.max(maxWeight, weight);
        }

        st = new StringTokenizer(br.readLine());

        start = Integer.parseInt(st.nextToken());
        dest = Integer.parseInt(st.nextToken());

        long left = 1;
        long right = maxWeight;
        long answer = 0;

        while (left <= right) {
            long mid = (left + right) / 2;

            if (canReach(mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }

    public static boolean canReach(long minWeight) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int curNode = queue.poll();

            if (curNode == dest) {
                return true;
            }
            for (long[] next : graph.get(curNode)) {
                int nextNode = (int) next[0];
                long nextWeight = next[1];

                if (!visited[nextNode] && minWeight <= nextWeight) {
                    queue.offer(nextNode);
                    visited[nextNode] = true;
                }
            }
        }

        return false;
    }
}