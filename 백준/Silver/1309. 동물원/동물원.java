import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n + 1][3];
        dp[0][0] = 1;

        for (int r = 1; r <= n; r++) {
            dp[r][0] = (dp[r - 1][0] + dp[r - 1][1] + dp[r - 1][2]) % 9901;
            dp[r][1] = (dp[r - 1][0] + dp[r - 1][2]) % 9901;
            dp[r][2] = (dp[r - 1][1] + dp[r - 1][0]) % 9901;
        }

        System.out.println((dp[n][0] + dp[n][1] + dp[n][2]) % 9901);
    }
}