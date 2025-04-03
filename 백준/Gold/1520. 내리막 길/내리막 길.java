import java.io.*;
import java.util.*;

class Main {
    static int[][] directions = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
    static int n, m;
    static int[][] map;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        dp = new int[n][m];
        for (int r = 0; r < n; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < m; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                dp[r][c] = -1;
            }
        }

        System.out.println(dfs(0, 0));
    }

    public static int dfs(int row, int col) {
        if (row == n - 1 && col == m - 1) {
            return 1;
        }
        if (dp[row][col] != -1) {
            return dp[row][col];
        }

        dp[row][col] = 0;

        for (int[] dir : directions) {
            int nextRow = dir[0] + row;
            int nextCol = dir[1] + col;

            if (isInRange(nextRow, nextCol) && map[nextRow][nextCol] < map[row][col]) {
                dp[row][col] += dfs(nextRow, nextCol);
            }
        }

        return dp[row][col];
    }

    public static boolean isInRange(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }
}