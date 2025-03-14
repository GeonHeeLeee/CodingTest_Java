import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int trial = 0; trial < t; trial++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[] constructTime = new int[n + 1];
            List<Integer>[] graph = new ArrayList[n + 1];
            int[] inDegrees = new int[n + 1];

            for (int idx = 1; idx <= n; idx++) {
                graph[idx] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                constructTime[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                graph[start].add(end);
                inDegrees[end]++;
            }

            int dest = Integer.parseInt(br.readLine());

            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
            for (int idx = 1; idx <= n; idx++) {
                if (inDegrees[idx] == 0) {
                    pq.offer(new int[] { idx, constructTime[idx] });
                }
            }

            int answer = Integer.MAX_VALUE;

            while (!pq.isEmpty()) {
                int[] current = pq.poll();
                int curNode = current[0];
                int curConstructTime = current[1];

                if (curNode == dest) {
                    answer = Math.min(answer, curConstructTime);
                }

                for (int next : graph[curNode]) {
                    inDegrees[next]--;
                    if (inDegrees[next] == 0) {
                        pq.offer(new int[] { next, curConstructTime + constructTime[next] });
                    }
                }
            }

            System.out.println(answer);
        }
    }
}