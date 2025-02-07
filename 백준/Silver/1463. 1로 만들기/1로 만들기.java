import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n+1];
        for(int idx = 2; idx <= n; idx ++) {
            dp[idx] = dp[idx-1] + 1;
            if(idx % 3 == 0) {
                dp[idx] = Math.min(dp[idx], dp[idx / 3] + 1);
            }
            if(idx % 2 == 0) {
                dp[idx] = Math.min(dp[idx], dp[idx / 2] + 1);
            }
        }

        System.out.println(dp[n]);

    }
}
