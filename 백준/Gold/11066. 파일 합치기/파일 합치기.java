import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int trial = 0; trial < t; trial++) {
            int k = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] files = new int[k + 1];
            int[][] dp = new int[k + 1][k + 1];
            int[][] sum = new int[k + 1][k + 1];

            for (int i = 1; i <= k; i++) {
                files[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= k; i++) {
                sum[i][i] = files[i];
                for (int j = i + 1; j <= k; j++) {
                    sum[i][j] = sum[i][j - 1] + files[j];
                }
            }

            for(int len = 2; len <= k; len ++) {
                for(int i = 1; i + len - 1 <= k; i ++) {
                    int j = i + len - 1;
                    dp[i][j] = Integer.MAX_VALUE;
                    for(int p = i; p < j; p ++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][p] + dp[p + 1][j] + sum[i][j]);
                    }
                }
            }

            System.out.println(dp[1][k]);

            

        }


    }
}