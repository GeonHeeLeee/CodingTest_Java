import java.io.*;
import java.util.*;

class Main {

    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        int[][] dp = new int[n][n];
        for (int[] arr : dp) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int dept = Integer.parseInt(st.nextToken()) - 1;
            int dest = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());

            dp[dept][dest] = Math.min(dp[dept][dest], cost);
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()) - 1;
        int end = Integer.parseInt(st.nextToken()) - 1;

        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[] { start, 0 });

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int curLoc = current[0];
            int curCost = current[1];

            if (curLoc == end) {
                break;
            }

            for (int idx = 0; idx < n; idx++) {
                if (dp[curLoc][idx] != Integer.MAX_VALUE) {
                    int newCost = curCost + dp[curLoc][idx];
                    if (newCost < minCost[idx]) {
                        minCost[idx] = newCost;
                        pq.offer(new int[] { idx, newCost });
                    }
                }
            }
        }
        System.out.println(minCost[end]);
    }
}