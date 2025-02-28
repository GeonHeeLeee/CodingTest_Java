import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[k + 1];

        for (int coin : coins) {
            for (int i = 0; i <= k; i++) {
                if (i == coin) {
                    dp[i] = dp[i] + 1;
                } else if (i > coin) {
                    dp[i] = dp[i] + dp[i - coin];
                }
            }
        }

        System.out.println(dp[k]);
    }
}