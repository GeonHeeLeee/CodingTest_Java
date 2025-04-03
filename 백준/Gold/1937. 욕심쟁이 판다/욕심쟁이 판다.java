import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int[][] bamboos;
    static int[][] directions = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
    static int[][] dp;
    static int maxDist = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        bamboos = new int[n][n];
        dp = new int[n][n];

        for (int r = 0; r < n; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < n; c++) {
                bamboos[r][c] = Integer.parseInt(st.nextToken());
                dp[r][c] = -1;
            }
        }

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                maxDist = Math.max(maxDist, dfs(r, c));
            }
        }

        System.out.println(maxDist);

    }

    public static int dfs(int row, int col) {
        if (dp[row][col] != -1) {
            return dp[row][col];
        }

        dp[row][col] = 1;

        for (int[] dir : directions) {
            int nextRow = dir[0] + row;
            int nextCol = dir[1] + col;

            if (isInRange(nextRow, nextCol) && bamboos[nextRow][nextCol] < bamboos[row][col]) {
                dp[row][col] = Math.max(dp[row][col], dfs(nextRow, nextCol) + 1);
            }
        }

        return dp[row][col];
    }

    public static boolean isInRange(int row, int col) {
        return row >= 0 && col >= 0 && row < n && col < n;
    }
}