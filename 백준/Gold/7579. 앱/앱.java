import java.io.*;
import java.util.*;

class Main {
    static int n, m;
    static int[] ms;
    static int[] cs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        ms = new int[n];
        cs = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            ms[i] = Integer.parseInt(st.nextToken());
        }

        int sumCost = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cs[i] = Integer.parseInt(st.nextToken());
            sumCost += cs[i];
        }

        int[] dp = new int[sumCost + 1];

        for (int i = 0; i < n; i++) {
            for (int j = sumCost; j >= cs[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - cs[i]] + ms[i]);
            }
        }

        for (int j = 0; j <= sumCost; j++) {
            if (dp[j] >= m) {
                System.out.println(j);
                return;
            }
        }
    }
}