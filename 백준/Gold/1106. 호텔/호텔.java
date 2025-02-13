import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] dp = new int[c + 101];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int idx = 1; idx <= n; idx++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int customer = Integer.parseInt(st.nextToken());

            for (int i = customer; i < dp.length; i++) {
                if (dp[i - customer] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - customer] + cost);
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = c; i < dp.length; i++) {
            result = Math.min(result, dp[i]);
        }
        System.out.println(result);
    }
}
