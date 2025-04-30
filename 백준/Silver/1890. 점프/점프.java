import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int[][] directions = new int[][] { { 0, 1 }, { 1, 0 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int answer = 0;

        int[][] board = new int[n][n];

        for (int r = 0; r < n; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < n; c++) {
                board[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        long[][] dp = new long[n][n];

        dp[0][0] = 1;

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (dp[r][c] == 0 || board[r][c] == 0) {
                    continue;
                }

                int jump = board[r][c];

                if (r + jump < n) {
                    dp[r + jump][c] += dp[r][c];
                }
                if (c + jump < n) {
                    dp[r][c + jump] += dp[r][c];
                }
            }
        }

        System.out.println(dp[n - 1][n - 1]);
    }
}