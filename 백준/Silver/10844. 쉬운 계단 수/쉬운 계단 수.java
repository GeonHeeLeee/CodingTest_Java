import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int MOD = 1000000000;
        int[][] dp = new int[n + 1][10];

        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int row = 2; row <= n; row++) {
            for (int col = 0; col <= 9; col++) {
                if (col == 0) {
                    dp[row][col] = dp[row - 1][1] % MOD;
                } else if (col == 9) {
                    dp[row][col] = dp[row - 1][8] % MOD;
                } else {
                    dp[row][col] = (dp[row - 1][col - 1] + dp[row - 1][col + 1]) % MOD;
                }
            }
        }

        int answer = 0;

        for (int i = 0; i <= 9; i++) {
            answer = (answer + dp[n][i]) % MOD;
        }
        System.out.println(answer);
    }
}