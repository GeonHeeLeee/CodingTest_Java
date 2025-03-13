import java.io.*;
import java.util.*;

class Main {
    static int n, m;
    static int[][] rect;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        rect = new int[n][m];
        int[][] dp = new int[n][m];
        for (int r = 0; r < n; r++) {
            char[] input = br.readLine().toCharArray();
            for (int c = 0; c < m; c++) {
                rect[r][c] = input[c] - '0';
            }
        }

        int maxRect = 0;

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (rect[r][c] == 1) {
                    if (r == 0 || c == 0) {
                        dp[r][c] = 1;
                    } else {
                        dp[r][c] = Math.min(Math.min(dp[r - 1][c], dp[r][c - 1]), dp[r - 1][c - 1]) + 1;
                    }
                }

                maxRect = Math.max(dp[r][c], maxRect);
            }
        }

        System.out.println(maxRect * maxRect);
    }

}