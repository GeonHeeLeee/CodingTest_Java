import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[] dp = new int[t + 1];

        for (int idx = 1; idx <= n; idx++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());

            for (int i = t; i >= time; i--) {
                dp[i] = Math.max(dp[i], dp[i - time] + score);
            }
        }

        int maxScore = 0;

        for (int score : dp) {
            maxScore = Math.max(maxScore, score);
        }
        System.out.println(maxScore);
    }

}
