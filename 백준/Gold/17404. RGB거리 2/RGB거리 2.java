import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int[][] costs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        costs = new int[n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < 3; c++) {
                costs[i][c] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = Integer.MAX_VALUE;

        for (int firstColor = 0; firstColor < 3; firstColor++) {
            int[][] dp = new int[n][3];
            for (int c = 0; c < 3; c++) {
                if (c == firstColor) {
                    dp[0][c] = costs[0][c];
                } else {
                    dp[0][c] = 1000 * 1000;
                }
            }

            for (int i = 1; i < n; i++) {
                dp[i][0] = costs[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
                dp[i][1] = costs[i][1] + Math.min(dp[i - 1][2], dp[i - 1][0]);
                dp[i][2] = costs[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
            }

            for (int lastColor = 0; lastColor < 3; lastColor++) {
                if (lastColor == firstColor) {
                    continue;
                }
                answer = Math.min(answer, dp[n - 1][lastColor]);
            }
        }

        System.out.println(answer);
    }
}