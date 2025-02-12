import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] lostHps = new int[n + 1];
        int[] gainJoys = new int[n + 1];
        for (int idx = 1; idx <= n; idx++) {
            lostHps[idx] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int idx = 1; idx <= n; idx++) {
            gainJoys[idx] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[101];

        for (int i = 1; i <= n; i++) {
            for (int idx = 100; idx >= lostHps[i]; idx--) {
                dp[idx] = Math.max(dp[idx], dp[idx - lostHps[i]] + gainJoys[i]);
            }
        }

        int maxJoy = 0;

        for (int idx = 1; idx < 100; idx++) {
            maxJoy = Math.max(maxJoy, dp[idx]);
        }
        System.out.println(maxJoy);
    }
}
