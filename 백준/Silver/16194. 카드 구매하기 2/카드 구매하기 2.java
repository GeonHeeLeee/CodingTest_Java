import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        int[] prices = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prices[i] = Integer.parseInt(st.nextToken());
        }


        for(int i = 1; i <= n; i ++) {
            for(int j = i; j <= n; j ++) {
                dp[j] = Math.min(dp[j], dp[j - i] + prices[i]);
            }
        }
        System.out.println(dp[n]);
    }
}