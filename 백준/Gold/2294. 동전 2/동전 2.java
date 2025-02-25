import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] dp = new int[k + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            int coin = Integer.parseInt(br.readLine());
            for (int idx = coin; idx <= k; idx++) {
                if(dp[idx - coin] != Integer.MAX_VALUE) {
                    dp[idx] = Math.min(dp[idx], dp[idx - coin] + 1);
                }
            }
        }
        if (dp[k] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dp[k]);
        }

    }
}