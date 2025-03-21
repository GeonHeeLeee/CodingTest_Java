import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int[][] bamboos;
    static int[][] directions = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

    static int maxDist = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        bamboos = new int[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        for (int r = 0; r < n; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < n; c++) {
                bamboos[r][c] = Integer.parseInt(st.nextToken());
                pq.offer(new int[] { r, c, bamboos[r][c] });
            }
        }

        int[][] dp = new int[n][n];

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int r = current[0];
            int c = current[1];

            for (int[] dir : directions) {
                int dr = r + dir[0];
                int dc = c + dir[1];

                if (isInRange(dr, dc) && bamboos[dr][dc] < bamboos[r][c]) {
                    dp[r][c] = Math.max(dp[r][c], dp[dr][dc] + 1);
                }
            }
            maxDist = Math.max(dp[r][c], maxDist);
        }

        System.out.println(maxDist + 1);
    }

    public static boolean isInRange(int row, int col) {
        return row >= 0 && col >= 0 && row < n && col < n;
    }
}